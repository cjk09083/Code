
let lineData = {}; // lineData 객체 생성
const init_lon = 126.9781553; // 초기 경도값 상수
const init_lat = 37.5666454; // 초기 위도값 상수

let zoom = 18; // zoom level 상수

let r1Path = []; // Rover1의 경로를 저장할 배열
let r2Path = []; // Rover2의 경로를 저장할 배열

let r1Polyline = ""; // Rover1의 Polyline을 저장할 변수
let r1Marker = ""; // Rover1의 Marker을 저장할 변수
let r1Info = ""; // Rover1의 정보창을 저장할 변수

let r2Polyline = ""; // Rover2의 Polyline을 저장할 변수
let r2Marker = ""; // Rover2의 Marker을 저장할 변수
let r2Info = ""; // Rover2의 정보창을 저장할 변수

let r1Tbody = ""; // Rover1의 위치 데이터를 저장할 tbody
let r2Tbody = ""; // Rover2의 위치 데이터를 저장할 tbody

// Map을 초기화하는 함수
function initMap() {
	console.log("Map 생성");
	const mapOptions = {
		center: new naver.maps.LatLng(init_lat, init_lon),
		zoom: zoom,
		scaleControl: true,
		mapDataControl: false,
		zoomControl: true,
		zoomControlOptions: {
			style: naver.maps.ZoomControlStyle.LARGE,
			position: naver.maps.Position.TOP_RIGHT
		},
		mapTypeControl: true,
		mapTypeControlOptions: {
			mapTypeIds:[naver.maps.MapTypeId.NORMAL,naver.maps.MapTypeId.SATELLITE,naver.maps.MapTypeId.HYBRID],
			style: naver.maps.ZoomControlStyle.BUTTON,
			position: naver.maps.Position.TOP_RIGHT
		},
	};
	const container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스

	map = new naver.maps.Map(container,mapOptions);

	let button1 = document.getElementById("button1"); // Rover1 버튼 요소 가져오기
	let button2 = document.getElementById("button2"); // Rover2 버튼 요소 가져오기

	button1.addEventListener("click", function () {
		button1.classList.add("active"); // 버튼 1 활성화
		button2.classList.remove("active"); // 버튼 2 비활성화
		$("#dataBody").html(r1Tbody); // Rover1의 위치 데이터로 tbody 채우기
	});

	button2.addEventListener("click", function () {
		button2.classList.add("active"); // 버튼 2 활성화
		button1.classList.remove("active"); // 버튼 1 비활성화
		$("#dataBody").html(r2Tbody); // Rover2의 위치 데이터로 tbody 채우기
	});
	naver.maps.Event.addListener(map, 'click', function(mouseEvent) {
		console.log("map click: " + mouseEvent.latlng._lat+", "+mouseEvent.latlng._lng); 
		hidePopup();
	});
}

// 모든 Marker와 Polyline, InfoWindow를 삭제하는 함수
function removeAllMarker() {
	hidePopup();
	if(r1Path.length > 0 ){
		r1Polyline.setMap(null);
		r1Marker.setMap(null);
	}

	if(r2Path.length > 0 ){
		r2Polyline.setMap(null);
		r2Marker.setMap(null);
	}
}

// 모든 nfoWindow를 Close하는 함수
function hidePopup(){
	if(r1Path.length > 0 && r1Info != '' ){
		r1Info.close();
	}
	if(r2Path.length > 0  && r2Info != '' ){
		r2Info.close();
	}
}


// 모든 Marker와 Polyline, InfoWindow를 새로 추가하는 함수
function addLine() {
	removeAllMarker();
	r1Path = []
	r2Path = []
	let r1Last = "";
	let r2Last = "";
	r1Tbody = "";
	r2Tbody = "";
	r1Info = '';
	r2Info = '';
	
	for (let key in lineData) {
		const item = lineData[key];	
		if (item.r1Lat > 0 && item.r1Status > 0){
			r1Path.push(new naver.maps.LatLng(item.r1Lat, item.r1Lon))
			r1Last = item;
			r1Tbody = "<tr onclick=\"focusMarker(\'"+item.created_at+"\',\'"+item.r1Lat+"\',\'"+item.r1Lon+"\',\'Rover1\')\"><td>"+
				item.id+"</td><td>"+item.created_at+"</td><td>"+item.r1Lat+"</td><td>"+item.r1Lon+"</td></tr>" + r1Tbody
		}

		if (item.r2Lat > 0  && item.r2Status > 0){
			r2Path.push(new naver.maps.LatLng(item.r2Lat, item.r2Lon))
			r2Last = item;
			r2Tbody = "<tr onclick=\"focusMarker(\'"+item.created_at+"\',\'"+item.r2Lat+"\',\'"+item.r2Lon+"\',\'Rover2\')\"><td>"+
				item.id+"</td><td>"+item.created_at+"</td><td>"+item.r2Lat+"</td><td>"+item.r2Lon+"</td></tr>" + r2Tbody
		}
	}

    if (r2Path.length > 0){
		const contentString = "<div style='letter-spacing: 1px;line-height: 25px; border: 2px solid black; border-radius: 10px; padding: 10px;'>"+
							"<b>Rover2 좌표</b></br>"+ 
							"위도: "+r2Last.r2Lat+"</br>"+
							"경도: "+r2Last.r2Lon+"</br>"+
							r2Last.created_at+"</br>"+
							"</div>"
		r2Info =  new naver.maps.InfoWindow({
			content: contentString,
			borderWidth: 0,
			disableAnchor: true,
			backgroundColor: 'rgba(255, 255, 255, 0.8)',
			pixelOffset: new naver.maps.Point(0, -5),
		});

		//위의 배열을 이용해 라인 그리기
		r2Polyline = new naver.maps.Polyline({
			path: r2Path,      //선 위치 변수배열
			strokeColor: '#0000FF', //선 색 빨강 #빨강,초록,파랑
			strokeOpacity: 0.8, //선 투명도 0 ~ 1
			strokeWeight: 3,   //선 두께
			map: map           //오버레이할 지도
		});
		// 배열 마지막 위치를 마커로 표시함
		r2Marker = new naver.maps.Marker({
			position: r2Path[r2Path.length-1],
			map: map,
			icon: {
				content: '<svg xmlns="http://www.w3.org/2000/svg" width="22" height="35"><path fill="#0072b2" d="M11,34.1C5.6,24.2,0,14.7,0,9.6c0-6,4.8-10.8,10.8-10.8c6,0,10.8,4.8,10.8,10.8C21.6,14.7,16,24.2,11,34.1z M10.8,5.4C7.2,5.4,4.5,8.1,4.5,11.7s2.7,6.3,6.3,6.3s6.3-2.7,6.3-6.3S14.4,5.4,10.8,5.4z"/></svg>',
				anchor: new naver.maps.Point(11, 35)
			}
		});
		
		r2Polyline.setMap(map);
		r2Marker.setMap(map);
		naver.maps.Event.addListener(r2Marker, 'click', function() {
			r2Info.open(map, r2Marker)
		});
		$('#dataBody').html(r2Tbody);
		map.setCenter(r2Path[r2Path.length-1]); // 중심 좌표 이동
		$('#button2').click();
		console.log("r2 line add")
	}

	
	if (r1Path.length > 0){
		const contentString = "<div style='letter-spacing: 1px;line-height: 25px; border: 2px solid black; border-radius: 10px; padding: 10px;'>"+
							"<b>Rover1 좌표</b></br>"+ 
							"위도: "+r1Last.r1Lat+"</br>"+
							"경도: "+r1Last.r1Lon+"</br>"+
							r1Last.created_at+"</br>"+
							"</div>"

		r1Info =  new naver.maps.InfoWindow({
			content: contentString,
			borderWidth: 0,
			disableAnchor: true,
			backgroundColor: 'rgba(255, 255, 255, 0.8)',
			pixelOffset: new naver.maps.Point(0, -5),
		});

		//위의 배열을 이용해 라인 그리기
		r1Polyline = new naver.maps.Polyline({
			path: r1Path,      //선 위치 변수배열
			strokeColor: '#FF0000', //선 색 빨강 #빨강,초록,파랑
			strokeOpacity: 0.8, //선 투명도 0 ~ 1
			strokeWeight: 3,   //선 두께
			map: map           //오버레이할 지도
		});

			
		// 배열 마지막 위치를 마커로 표시함
		r1Marker = new naver.maps.Marker({
			position: r1Path[r1Path.length-1],
			map: map,
			icon: {
				content: '<svg xmlns="http://www.w3.org/2000/svg" width="22" height="35"><path fill="#ff0000" d="M11,34.1C5.6,24.2,0,14.7,0,9.6c0-6,4.8-10.8,10.8-10.8c6,0,10.8,4.8,10.8,10.8C21.6,14.7,16,24.2,11,34.1z M10.8,5.4C7.2,5.4,4.5,8.1,4.5,11.7s2.7,6.3,6.3,6.3s6.3-2.7,6.3-6.3S14.4,5.4,10.8,5.4z"/></svg>',
				anchor: new naver.maps.Point(11, 35)
			}
		});

		r1Polyline.setMap(map);
		r1Marker.setMap(map);
		naver.maps.Event.addListener(r1Marker, 'click', function() {
			r1Info.open(map, r1Marker)
		});
		map.setCenter(r1Path[r1Path.length-1]); // 중심 좌표 이동
		$('#dataBody').html(r1Tbody);
		$('#button1').click();
		console.log("r1 line add")
	}
	map.setZoom(zoom); 
}

// 클릭한 Rover data의 좌표로 Marker를 재생성 하는 함수
function focusMarker(time,lat,lon,type) {
	console.log("focus to "+type+" marker : "+time+" ["+lat+", "+lon+"]")

	if (lat == 0 || lon == 0){
		return;
	}
	let pos = new naver.maps.LatLng(lat, lon)
	map.setCenter(pos); // 중심 좌표 이동
	
	const contentString = "<div style='letter-spacing: 1px;line-height: 25px; border: 2px solid black; border-radius: 10px; padding: 10px;'>"+
			"<b>"+type+" 좌표</b></br>"+ 
			"위도: "+lat+"</br>"+
			"경도: "+lon+"</br>"+
			time+"</br>"+
			"</div>"

	if (type == "Rover1"){
		r1Marker.setMap(null);
		r1Info =  new naver.maps.InfoWindow({
			content: contentString,
			borderWidth: 0,
			disableAnchor: true,
			backgroundColor: 'rgba(255, 255, 255, 0.8)',
			pixelOffset: new naver.maps.Point(0, -5),
		});
			
		// 배열 마지막 위치를 마크로 표시함
		r1Marker = new naver.maps.Marker({
			position: pos,
			map: map,
			icon: {
				content: '<svg xmlns="http://www.w3.org/2000/svg" width="22" height="35"><path fill="#ff0000" d="M11,34.1C5.6,24.2,0,14.7,0,9.6c0-6,4.8-10.8,10.8-10.8c6,0,10.8,4.8,10.8,10.8C21.6,14.7,16,24.2,11,34.1z M10.8,5.4C7.2,5.4,4.5,8.1,4.5,11.7s2.7,6.3,6.3,6.3s6.3-2.7,6.3-6.3S14.4,5.4,10.8,5.4z"/></svg>',
				anchor: new naver.maps.Point(11, 35)
			}
		});
		r1Marker.setMap(map);
		naver.maps.Event.addListener(r1Marker, 'click', function() {
			r1Info.open(map, r1Marker)
		});
		r1Info.open(map, r1Marker)
	}else{
		r2Marker.setMap(null);
		r2Info =  new naver.maps.InfoWindow({
			content: contentString,
			borderWidth: 0,
			disableAnchor: true,
			backgroundColor: 'rgba(255, 255, 255, 0.8)',
			pixelOffset: new naver.maps.Point(0, -5),
		});
			
		// 배열 마지막 위치를 마크로 표시함
		r2Marker = new naver.maps.Marker({
			position: pos,
			map: map,
			icon: {
				content: '<svg xmlns="http://www.w3.org/2000/svg" width="22" height="35"><path fill="#0072b2" d="M11,34.1C5.6,24.2,0,14.7,0,9.6c0-6,4.8-10.8,10.8-10.8c6,0,10.8,4.8,10.8,10.8C21.6,14.7,16,24.2,11,34.1z M10.8,5.4C7.2,5.4,4.5,8.1,4.5,11.7s2.7,6.3,6.3,6.3s6.3-2.7,6.3-6.3S14.4,5.4,10.8,5.4z"/></svg>',
				anchor: new naver.maps.Point(11, 35)
			}
		});
		r2Marker.setMap(map);
		naver.maps.Event.addListener(r2Marker, 'click', function() {
			r2Info.open(map, r2Marker)
		});
		r2Info.open(map, r2Marker)
	}
}

// Rover Data를 받아오는 함수
function updateMap(){
    $.ajax({
		url: "get_rover_pos.php",
		method: "POST",
		success: function(data){ 
			const json_obj = JSON.parse(data);
			console.log(json_obj);
			if(json_obj.success == true){	
				lineData = json_obj.data;
				addLine();
			}else{
				console.log("fail")
			}
		},
		error: function(data){
			console.log(data);
		}
		
	});
}

$(document).ready(function() {
	initMap();
	updateMap();
});

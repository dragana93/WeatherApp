function getRequest() {
	if (window.XMLHttpRequest) {
		return (new XMLHttpRequest());
	} else if (window.ActiveXObject) {
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	} else {
		return (null);
	}
}

function caching() {
	var cookie = document.cookie;
	console.log("cookie: " + cookie);
	if (cookie) {
		var x1 = cookie.split(";")[0];
		var latDep = x1.split("=")[1];
		var y1 = cookie.split(";")[1];
		var lonDep = y1.split("=")[1];
		console.log("lat: " + latDep);
		console.log("lon: " + lonDep);
		document.getElementById("latitude").value = latDep;
		document.getElementById("longitude").value = lonDep;
		var x2 = cookie.split(";")[2];
		var latDepDest = x2.split("=")[1];
		var y2 = cookie.split(";")[3];
		var lonDepDest = y2.split("=")[1];
		console.log("latDest: " + latDepDest);
		console.log("lonDest: " + lonDepDest);
		document.getElementById("latitudeDest").value = latDepDest;
		document.getElementById("longitudeDest").value = lonDepDest;
		loadData();
		loadDataDest();
	}

	// console.log(latDep + " " + lonDep);

}

function loadData() {
	var request = getRequest();

	var latitude = document.getElementById("latitude").value;
	var longitude = document.getElementById("longitude").value;

	console.log("latitude " + latitude + ", longitude " + longitude);

	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var odgovor = JSON.parse(request.responseText);
			var dewPoint = odgovor["dewPoint"];
			var humidity = odgovor["humidity"];
			var temperature = odgovor["temperature"];

			var fog = odgovor["fog"];
			var lowClouds = odgovor["lowClouds"];
			var mediumCluods = odgovor["mediumCluods"];
			var highClouds = odgovor["highClouds"];

			var slika1 = odgovor["pictureFog"];
			var slika2 = odgovor["pictureLow"];
			var slika3 = odgovor["pictureMedium"];
			var slika4 = odgovor["pictureHigh"];
			document.getElementById("dewPoint").innerHTML = '<b>Dew Point:</b> '
					+ dewPoint;
			document.getElementById("humidity").innerHTML = '<b>Humidity: </b> '
					+ humidity;
			document.getElementById("temperature").innerHTML = '<b>Temperature:</b> '
					+ temperature;

			document.getElementById("fog").innerHTML = fog + "% Fog";
			document.getElementById("lowClouds").innerHTML = lowClouds
					+ "%<br/>Low<br/>Clouds";
			document.getElementById("mediumCluods").innerHTML = mediumCluods
					+ "%<br/>Medium<br/>Clouds";
			document.getElementById("highClouds").innerHTML = highClouds
					+ "%<br/>High<br/>Clouds";

			document.getElementById("slika1").src = "pictures/" + slika1;
			document.getElementById("slika2").src = "pictures/" + slika2;
			document.getElementById("slika3").src = "pictures/" + slika3;
			document.getElementById("slika4").src = "pictures/" + slika4;

			document.getElementById("slika1").style.display = "inline";
			document.getElementById("slika2").style.display = "inline";
			document.getElementById("slika3").style.display = "inline";
			document.getElementById("slika4").style.display = "inline";

			console.log("dewPoint " + dewPoint + " hum " + humidity
					+ " temperature " + temperature);

		}
	}
	request.open("GET", "Servlet?parm=sendData&latitude=" + latitude
			+ "&longitude=" + longitude, true);
	request.send();

}

function loadDataDest() {
	var request = getRequest();

	var latitude = document.getElementById("latitudeDest").value;
	var longitude = document.getElementById("longitudeDest").value;

	console.log("latitude dest " + latitude + ", longitude dest " + longitude);

	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var odgovor = JSON.parse(request.responseText);
			var dewPoint = odgovor["dewPoint"];
			var humidity = odgovor["humidity"];
			var temperature = odgovor["temperature"];

			var fog = odgovor["fog"];
			var lowClouds = odgovor["lowClouds"];
			var mediumCluods = odgovor["mediumCluods"];
			var highClouds = odgovor["highClouds"];

			var slika5 = odgovor["pictureFog"];
			var slika6 = odgovor["pictureLow"];
			var slika7 = odgovor["pictureMedium"];
			var slika8 = odgovor["pictureHigh"];

			document.getElementById("dewPointDest").innerHTML = '<b>Dew Point:</b> '
					+ dewPoint;
			document.getElementById("humidityDest").innerHTML = '<b>Humidity: </b> '
					+ humidity;
			document.getElementById("temperatureDest").innerHTML = '<b>Temperature:</b> '
					+ temperature;

			document.getElementById("fogDest").innerHTML = fog + "% Fog";
			document.getElementById("lowCloudsDest").innerHTML = lowClouds
					+ "%<br/>Low<br/>Clouds";
			document.getElementById("mediumCluodsDest").innerHTML = mediumCluods
					+ "%<br/>Medium<br/>Clouds";
			document.getElementById("highCloudsDest").innerHTML = highClouds
					+ "%<br/>High<br/>Clouds";

			document.getElementById("slika5").src = "pictures/" + slika5;
			document.getElementById("slika6").src = "pictures/" + slika6;
			document.getElementById("slika7").src = "pictures/" + slika7;
			document.getElementById("slika8").src = "pictures/" + slika8;

			document.getElementById("slika5").style.display = "inline";
			document.getElementById("slika6").style.display = "inline";
			document.getElementById("slika7").style.display = "inline";
			document.getElementById("slika8").style.display = "inline";

			console.log("dewPoint " + dewPoint + " hum " + humidity
					+ " temperature " + temperature);
		}
	}
	request.open("GET", "Servlet?parm=sendDataDest&latitudeDest=" + latitude
			+ "&longitudeDest=" + longitude, true);
	request.send();

}
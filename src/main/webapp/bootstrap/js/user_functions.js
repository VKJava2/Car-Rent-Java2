function selectChain() {
    var firstSelectChosen = document.getElementById('defaultVehicle').value;
    if (firstSelectChosen === "empty") {
        document.getElementById('defaultModel').disabled = true;
        document.getElementById('defaultModel').value = "empty";
    }
    else {
        document.getElementById('defaultModel').disabled = false;
    }
}

function logoSizeOnWindowResize() {
    var w = window,
            d = document,
            e = d.documentElement,
            g = d.getElementsByTagName('body')[0],
            x = w.innerWidth || e.clientWidth || g.clientWidth,
            y = w.innerHeight || e.clientHeight || g.clientHeight;
    if (x < 348) {
        document.getElementById("logoImage").width = "188";
        document.getElementById("logoImage").height = "30";
    } else {
        document.getElementById("logoImage").width = "252";
        document.getElementById("logoImage").height = "40";
    }

}
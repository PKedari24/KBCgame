function startGame() {
    const url = window.location.origin + "/game"; 
    QRCode.toCanvas(document.getElementById('qrcode'), url, function (error) {
        if (error) console.error(error); 
        console.log('QR code generated!');
    });
}

function submitAnswer() {
    const playerName = document.getElementById('playerName').value; 
    const answer = document.getElementById('answer').value;

    fetch('/answer', { 
        method: 'POST', 
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `playerName=${playerName}&answer=${answer}`
    })
    .then(response => response.text())
    .then(data => { 
        document.getElementById('result').innerText = data;
    });
}
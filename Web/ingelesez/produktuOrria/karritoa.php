<?php
require_once("../header.php");
?>

<html>

<head>
    <title>Zure Karritoa</title>
    <link rel="stylesheet" href="karritoa.css">
    <?php require_once("../head.php"); ?>
</head>

<body>
    <div class="content-osoa">

        <h1 id="enpresaIzena">EkoTekno</h1>
        <br><br>

        <h2 id="zureKarritoaTitulua">Zure Karritoa</h2>
        <div id="karritoa-edukia"></div>
        <br>
        <div id="karrito-botoiak">
            <button id="erosi" onclick="erosiProduktuak()">Erosi</button>
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                let karritoaEdukia = document.getElementById("karritoa-edukia");
                let karritoa = JSON.parse(localStorage.getItem("karritoa")) || [];

                function erakutsiKarritoa() {
                    karritoaEdukia.innerHTML = "";
                    if (karritoa.length === 0) {
                        karritoaEdukia.innerHTML = "<p>Karritoa hutsik dago.</p>";
                        return;
                    }
                    karritoa.forEach((produktua, index) => {
                        let produktuaDiv = document.createElement("div");
                        produktuaDiv.innerHTML = `
                <span>${produktua.izena} - $${produktua.prezioa} x ${produktua.kopurua}</span>
                <button onclick="ezabatuProduktua(${index})">Ezabatu</button>
            `;
                        karritoaEdukia.appendChild(produktuaDiv);
                    });
                }

                window.ezabatuProduktua = function (index) {
                    karritoa.splice(index, 1);
                    localStorage.setItem("karritoa", JSON.stringify(karritoa));
                    erakutsiKarritoa();
                };

                window.erosiProduktuak = function () {
                    window.location.href = "ordaindu.php"; // Página de pago
                };

                erakutsiKarritoa();
            });
        </script>
    </div>

    <?php require_once("../footer.php"); ?>
</body>

</html>
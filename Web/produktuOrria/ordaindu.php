<?php
require_once("../header.php");
?>

<html>

<head>
    <title>Ordaindu - Erosketa Berretsi</title>
    <link rel="stylesheet" href="ordaindu.css">
    <?php require_once("../head.php"); ?>
</head>

<body>
    <div class="content-osoa">
        <h1 id="enpresaIzena">EkoTekno</h1>
        <br><br>
        <h2 id="ordainduTitulua">Ordaindu</h2>
        <div id="ordainketa-edukia"></div>
        <br><br>
        <div id="ordaindu-botoiak">
            <button id="erosketaBerretsi" onclick="berretsiErosketa()">Erosketa Berretsi</button>
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                let ordainketaEdukia = document.getElementById("ordainketa-edukia");
                let karritoa = JSON.parse(localStorage.getItem("karritoa")) || [];

                function erakutsiErosketa() {
                    ordainketaEdukia.innerHTML = "";
                    if (karritoa.length === 0) {
                        ordainketaEdukia.innerHTML = "<p>Ez dago produkturik karritoan.</p>";
                        return;
                    }

                    let guztira = 0;
                    let lista = "<ul>";
                    karritoa.forEach(produktua => {
                        lista += `<li>${produktua.izena} - $${produktua.prezioa} x ${produktua.kopurua}</li>`;
                        guztira += produktua.prezioa * produktua.kopurua;
                    });
                    lista += "</ul>";
                    ordainketaEdukia.innerHTML = lista + `<h3>Guztira: $${guztira.toFixed(2)}</h3>`;
                }

                window.berretsiErosketa = function () {
                    if (karritoa.length === 0) {
                        alert("Ez dago produkturik karritoan.");
                        return;
                    }

                    alert("Eskerrik asko zure erosketagatik! ");
                    localStorage.removeItem("karritoa");
                    window.location.href = "produktuOrria.php";
                };

                erakutsiErosketa();
            });
        </script>
    </div>

    <?php require_once("../footer.php"); ?>

</body>

</html>
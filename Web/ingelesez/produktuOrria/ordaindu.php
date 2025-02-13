<?php
require_once("../header.php");
?>

<html>

<head>
    <title>Pay</title>
    <link rel="stylesheet" href="ordaindu.css">
    <?php require_once("../head.php"); ?>
</head>

<body>
    <div class="content-osoa">
        <h1 id="enpresaIzena">EkoTekno</h1>
        <br><br>
        <h2 id="ordainduTitulua">Pay</h2>
        <div id="ordainketa-edukia"></div>
        <br><br>
        <div id="ordaindu-botoiak">
            <button id="erosketaBerretsi">Confirm purchase</button>
        </div>

        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>

        <script>
            $(document).ready(function () {
                erakutsiErosketa();
                $("#erosketaBerretsi").click(function () {
                    berretsiErosketa();
                });
            });

            function erakutsiErosketa() {
                let ordainketaEdukia = $("#ordainketa-edukia");
                let karritoa = JSON.parse(localStorage.getItem("karritoa")) || [];
                console.log(karritoa);

                ordainketaEdukia.html("");
                if (karritoa.length === 0) {
                    ordainketaEdukia.html("<p>There isn`t products in the cart.</p>");
                    return;
                }

                let guztira = 0;
                let lista = "<ul>";
                karritoa.forEach(produktua => {
                    lista += `<li>${produktua.izena} - $${produktua.prezioa} x ${produktua.kopurua}</li>`;
                    guztira += produktua.prezioa * produktua.kopurua;
                });
                lista += "</ul>";
                ordainketaEdukia.html(lista + `<h3>Guztira: $${guztira.toFixed(2)}</h3>`);
            }


            function berretsiErosketa() {
                let karritoa = JSON.parse(localStorage.getItem("karritoa")) || [];

                if (karritoa.length === 0) {
                    alert("There isn´t products in the cart.");
                    return;
                }

                $.ajax({
                    "url": "erosketaBerretsi.php",
                    "method": "POST",
                    "data": JSON.stringify({ karritoa })
                })
                    .done(function (data) {
                        data = JSON.parse(data);
                        if (data.success) {
                            alert("Thank you for your purchase!");
                            localStorage.removeItem("karritoa"); 
                            window.location.href = "produktuOrria.php"; 
                        } else {
                            alert("Error: " + data.error);
                        }
                    })
                    .fail(function () {
                        alert("There was an error with the server.");
                    });

            };

        </script>
    </div>

    <?php require_once("../footer.php"); ?>

</body>

</html>
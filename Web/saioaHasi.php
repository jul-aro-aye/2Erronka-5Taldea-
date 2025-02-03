<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sarrera</title>
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <?php

    require_once "header.php";
    echo sortuMenua();

    require_once "db.php";
    $conn = konexioaSortu();

    ?>
    <form action="saioaHasi.php" method="POST" id="saioaHasiForm">
        <label for="erab">Erabiltzailea</label>
        <input type="text" name="erab" id="erab" pattern="^[a-z]{3}_[a-z]{3}_[a-z]{3}$"
            title="Erabiltzailearen formatua ez da okerra, formatu egokia (xxx_xxx_xxx) da." required> <br><br>

        <label for="pasa">Pasahitza</label>
        <input type="password" name="pasa" id="pasa" required> <br><br>

        <div id="divBotoia">
            <button id="saioaBotoia2">Saioa Hasi</button>
        </div>

    </form>
    <?php

    ?>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script>
        $(document).ready(function () {

            $('#saioaBotoia2').on('click', function (e) {

                e.preventDefault();

            });

            $('#saioaBotoia2').on('click', function () {

                var erabiltzaileval = $("#erab").val();
                var pasahitzval = $("#pasa").val();

                $.ajax({
                    "url": "saioaBalidatu.php",
                    "method": "GET",
                    "data": {
                        "akzioa": "konprobatuSaioa",
                        "erabiltzailea": erabiltzaileval,
                        "pasahitza": pasahitzval,
                    }
                })
                    .done(function (konprobazioa) {

                        var saioKop = JSON.parse(konprobazioa);
                        if (saioKop.kopurua > 0) {
                            window.location.href = "https://www.w3schools.com/";
                        } else {
                            alert("Erabiltzaile eta pasahitz okerrak, saiatu berriro");
                        }

                    })
                    .fail(function () {
                        alert("gaizki joan da");
                    })
            });
        });

    </script>
</body>

</html>
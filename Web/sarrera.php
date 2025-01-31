<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sarrera</title>
    <link rel="stylesheet" href="css.css">
    <!-- https://fontawesome.com/icons/categories/coding -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <?php
    session_start();

    if (!isset($_SESSION['username'])) {
        // header('Location: login.php');  // Redirige a la página de login si no está logueado
        // exit();
    }
    
    require_once "header.php";
    echo sortuMenua();
    ?>

    <script>
        // var resultado = confirm("eKoTekno-n, zure nabigazio esperientzia hobetzeko, gure webgunearen erabilera aztertzeko eta eskaintzen dizkizugun edukia pertsonalizatzeko cookie-ak erabiltzen ditugu. Gure webgunean jarraituz, cookie-ak erabiltzea onartzen duzu gure cookie politikarekin bat etorriz. Cookie-en lehentasunak edozein unetan kudeatu ditzakezu zure nabigatzailearen konfigurazioaren bidez. Erabiltzen ditugun cookie-ak eta nola kontrolatu ditzakezun jakiteko, kontsultatu gure Pribatutasun Politika.");
        // if (!resultado) {
        //     window.history.back();
        // }
        // <a class="erosketa" href="Karritoa.php">
        // <img src="https://cdn-icons-png.flaticon.com/512/60/60992.png" height="30px" width="30px">
        // </a>

    </script>
</body>

</html>
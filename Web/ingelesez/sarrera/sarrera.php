    <html>

    <head>
        <?php

        // if (!isset($_SESSION['username'])) {
    //     // header('Location: login.php');  // Redirige a la página de login si no está logueado
    //     // exit();
    // }
        require_once "../head.php";

        ?>
        <link rel="stylesheet" href="sarrera.css">
        <title>Entry</title>

    </head>

    <body>
        <?php
        require_once "../header.php";
        ?>
        <div class="content-osoa">
            <h1 id="enpresaIzena">EkoTekno</h1>

            <div id="zerAurkitu">
                <h3 class="sarreraTitulua1">What you will find in EkoTekno?</h3>

                <img src="../CSS+Irudiak/ZerAurkitu.jpg" alt="Zer aurkitu argazkia" id="zerAurkituArgazkia" width="200px" height="200px"
                    ;>
                <ul id="zerAurkituLista">
                    <li>Computers and accessories – Laptops, desktop PCs, monitors, keyboards and more.
                    </li>
                    <li>Smartphones and accessories – Latest models, cases, chargers and smart devices.
                    </li>
                    <li>Gadgets and smart devices – Smartwatches, headphones, smart speakers and home automation.
                    </li>
                    <li>Components and gaming – Graphics cards, processors, gaming chairs and your experience
                    Everything you need to improve</li>
                </ul>
            </div>
            <div id="konpromisoa">
                <h3 class="sarreraTitulua2">Commitment to quality and personalized attention</h3>

                <img src="../CSS+Irudiak/Konpromiso.jpg" alt="Konpromisoa argazkia" id="konpromisoaArgazkia" width="200px"
                    height="200px" ;>
                <p class="konpromisoaTextua">EkoTekno, we are technology enthusiasts, and we love offering a close 
                    and reliable service. We will help you find the product that best suits your needs and budget. 
                    Our commitment to our customers is our priority, and we value you sharing your opinion with us. 
                </p>

            </div>

        </div>

        <script>
            // var cookiak = confirm("eKoTekno-n, zure nabigazio esperientzia hobetzeko, gure webgunearen erabilera aztertzeko eta eskaintzen dizkizugun edukia pertsonalizatzeko cookie-ak erabiltzen ditugu. Gure webgunean jarraituz, cookie-ak erabiltzea onartzen duzu gure cookie politikarekin bat etorriz. Cookie-en lehentasunak edozein unetan kudeatu ditzakezu zure nabigatzailearen konfigurazioaren bidez. Erabiltzen ditugun cookie-ak eta nola kontrolatu ditzakezun jakiteko, kontsultatu gure Pribatutasun Politika.");
            // if (!cookiak) {
            //     window.history.back();
            // }

        </script>

        <?php
        require_once "../footer.php";
        ?>

    </body>

    </html>
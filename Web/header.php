<?php
function sortuMenua()
{
    // session_start();

    // $logeatuta = isset($_SESSION['erabiltzailea']);

    ?>
    <header>
        <div class="header">

            <a href="javascript:void(0);" class="ikonoa" onclick="mugikorNabigazioa()">
                <i class="fa fa-bars" id="irudia"></i>
            </a>
            <div id="aukerak">
                <ul id="nabigazioBarra">
                    <li><a class="sarrera" href="sarrera.php">Sarrera</a></li><br>
                    <li><a class="produktuak" href="produktuak.php">Produktuak</a></li><br>
                    <li><a class="hornitzailea" href="form.php">Hornitzaile bihurtu</a></li><br>
                    <li><a class="berriak" href="berriak.php">Berriak</a></li>
                </ul>
            </div>
            <img src="Logoa_EkoTekno.jpg" id="logoa" alt="Logo EkoTekno">
            <div class="kontuak">
                <a href="saioaHasi.php"><i class="fa fa-user" id="login"></i></i></a>
                <a href="erregistroOrria.php"><i class="fa fa-user-plus" id="erregistratu"></i></a>

            </div>
        </div>

    </header>

    <h1 id="enpresaIzena">EkoTekno</h1>
    <script>
        function mugikorNabigazioa() {
            var ilara = document.getElementById("aukerak");
            if (ilara.style.display === "block") {
                ilara.style.display = "none";
            } else {
                ilara.style.display = "block";
            }
        }
    </script>
    <?php
}
?>
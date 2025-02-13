<?php
require_once "../saioaHasi/session.php";
?>

<div class="header">
    <a href="javascript:void(0);" class="ikonoa">
        <i class="fa fa-bars" id="irudia"></i>
    </a>
    <div id="aukerak">
        <ul id="nabigazioBarra">
            <li><a class="sarrera" href="../sarrera/sarrera.php">Entry</a></li><br>
            <li><a class="produktuak" href="../produktuOrria/produktuOrria.php">Products</a></li><br>
            <li><a class="hornitzailea" href="../hornitzaileBihurtu/hornitzaileBihurtu.php">Become a supplier</a></li>
            <br>
            <li><a class="berriak" href="../berriak/berriak.php">News</a></li>
        </ul>
    </div>

    <div class="kontuak">
        <?php if (isset($_SESSION['erabiltzailea'])): ?>
            <a href="../saioaHasi/saioaItxi.php" id="saioaItxiLink">Log out</a>
        <?php else: ?>
            <a href="../saioaHasi/saioaHasi.php"><i class="fa fa-user" id="login"></i></a>
        <?php endif; ?>
        <a href="../../euskeraz/sarrera/sarrera.php">
            <img src="../euskera.png" id="euskera" alt="Euskera">
        </a>
        <a href="../sarrera/sarrera.php">
            <img src="../ingelesa.jpg" id="ingelesa" alt="Ingelesa">
        </a>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
    $(document).ready(function () {
        $(".ikonoa").click(function () {
            mugikorNabigazioa();
        });
    });
    function mugikorNabigazioa() {
        var ilara = document.getElementById("aukerak");
        ilara.style.display = (ilara.style.display === "block") ? "none" : "block";
    }
</script>
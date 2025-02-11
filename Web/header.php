<div class="header">

    <a href="javascript:void(0);" class="ikonoa" onclick="mugikorNabigazioa()">
        <i class="fa fa-bars" id="irudia"></i>
    </a>
    <div id="aukerak">
        <ul id="nabigazioBarra">
            <li><a class="sarrera" href="../sarrera/sarrera.php">Sarrera</a></li><br>
            <li><a class="produktuak" href="../produktuOrria/produktuOrria.php">Produktuak</a></li><br>
            <li><a class="hornitzailea" href="../hornitzaileBihurtu/hornitzaileBihurtu.php">Hornitzaile bihurtu</a></li><br>
            <li><a class="berriak" href="../berriak/berriak.php">Berriak</a></li>
        </ul>
    </div>
    
    <div class="kontuak">
        <a href="../saioaHasi/saioaHasi.php"><i class="fa fa-user" id="login"></i></i></a>
        <img src="../euskera.png" id="euskera" alt="Euskera">
        <img src="../ingelesa.jpg" id="ingelesa" alt="Ingelesa">
    </div>
</div>


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
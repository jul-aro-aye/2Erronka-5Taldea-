<?php
require_once("../header.php");


require_once("../db.php");

$conn = konexioaSortu();


$sql = "SELECT title, text, data FROM berria";
$result = $conn->query($sql);

$irudiak = [
    "EkoTekno introduces its first eco-friendly smartphone." => "../CSS+Irudiak/MugikorEkologikoa.jpg",
    "EkoTekno has launched a smart solar charger." => "../CSS+Irudiak/Eguzki-kargagailuAdimenduna.jpg",
    "EkoTekno and AI: Developing Sustainable Artificial Intelligence" => "../CSS+Irudiak/AI.jpg",

]

    ?>
<html>

<head>
    <?php
    require_once "../head.php";
    ?>
    <title>News</title>

</head>

<body>
    <div class="content-osoa">
        <h1 id="enpresaIzena">EkoTekno</h1>
        <div id="berriak">

            <?php
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    $berrienIzenburu = $row["title"];


                    $berrienIrudi = isset($irudiak[$berrienIzenburu]) ? $irudiak[$berrienIzenburu] : "img/default.jpg";
                    echo "<div class='berria'>";
                    echo "<img src='" . $berrienIrudi . "' id='berrienIrudiak' height='150px' width='150px' alt='Berrien irudiak'" . htmlspecialchars($berrienIzenburu) . "'>";
                    echo "<br><br>";
                    echo "<h3>" . htmlspecialchars($row["title"]) . "</h3>";
                    echo "<p>" . htmlspecialchars($row["text"]) . "</p>";
                    echo "<p>" . htmlspecialchars($row["data"]) . "</p>";
                    echo "</div>";
                }
            } else {
                echo "<p>There isn´t news.</p>";
            }


            ?>
        </div>
    </div>

    <?php
    require_once "../footer.php";

    ?>
</body>

</html>
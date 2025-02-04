<?php
require_once("header.php");
echo sortuMenua();

require_once("db.php");

~$sql = "SELECT izena, prezioa FROM erronka2.produktua";
$resultado = $conn->query($sql);

$irudiak = [
    "iPhone 12" => "./CSS+Irudiak/Iphone12.jpg",
    "Galaxy S21" => "./CSS+Irudiak/GalaxyS21.jpg",
    "ThinkPad X1 Carbon" => "./CSS+Irudiak/ThinkPad.jpg",
    "MacBook Pro 13"=> "./CSS+Irudiak/Macbook.jpg",
    "iPad Air 4"=> "./CSS+Irudiak/IpadAir4.jpg",
    "Surface Pro 7"=> "./CSS+Irudiak/Surface.jpg",
    "PS5 Digital Edition"=> "./CSS+Irudiak/PS5.jpg",
    "Xbox Series S"=> "./CSS+Irudiak/Xbox.jpg",//Hemen
    "Nintendo Switch"=> "./CSS+Irudiak/Switch.jpg",
    "Dell XPS 13"=> "./CSS+Irudiak/Dell.jpg",
    "OnePlus 9"=> "./CSS+Irudiak/OnePlus.jpg",
    "Google Pixel 6"=> "./CSS+Irudiak/Pixel6.jpg",
    "ASUS ROG Strix G15"=> "./CSS+Irudiak/Asus.jpg",
    "Google Pixel 9"=> "./CSS+Irudiak/Pixel9.jpg",
    "HP Spectre x360"=> "./CSS+Irudiak/HP.jpg",
    "Huawei Mate Pad"=> "./CSS+Irudiak/Huawei.jpg",
    "Xiaomi Redmi 12 pro"=> "./CSS+Irudiak/Xiaomi.jpg",
    


]

?>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Filtratu</title>
    <link rel="stylesheet" href="./CSS+Irudiak/css.css">
    <!-- https://fontawesome.com/icons/categories/coding -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    
</head>
<body>
<div id="produktuak">
        
        <?php
        if ($resultado->num_rows > 0) {
            while ($row = $resultado->fetch_assoc()) {
                $produktuIzena = $row["izena"];

                
                $produktuIrudi = isset($irudiak[$produktuIzena]) ? $irudiak[$produktuIzena] : "img/default.jpg";
                echo "<div class='produktua'>";
                echo "<img src='" . $produktuIrudi . "' height='100px' width='100px' alt='" . htmlspecialchars($produktuIzena) . "'>";
                echo "<h3>" . htmlspecialchars($row["izena"]) . "</h3>";
                echo "<p>Precio: $" . number_format($row["prezioa"], 2) . "</p>";
                echo "</div>";
            }
        } else {
            echo "<p>Ez daude produkturik.</p>";
        }
        ?>
    </div>
</body>
</html>

<?php
     require_once("db.php");
    
    $izenAbizenak = "";
    $erabiltzailea = "";
    $pasahitza = "";
    $telefonoa = "";
    $emaila = "";
    

    if(isset($_POST["izenAbizenak"]) && !empty($_POST["izenAbizenak"])) {
        $izenAbizenak = $_POST["izenAbizenak"];
    }
    
    if(isset($_POST["erabiltzailea"]) && !empty($_POST["erabiltzailea"])) {
        $erabiltzailea = $_POST["erabiltzailea"];
    }   

    if(isset($_POST["pasahitza"]) && !empty($_POST["pasahitza"])) {
        $pasahitza = $_POST["pasahitza"];
    }   

    if(isset($_POST["telefono"]) && !empty($_POST["telefono"])) {
        $telefonoa = $_POST["telefono"];
    }   

    if(isset($_POST["emaila"]) && !empty($_POST["emaila"])) {
        $emaila = $_POST["emaila"]; 
    }   

    $kontsulta = "INSERT INTO bezeroa (izenAbizenak, erabiltzailea, pasahitza, telefonoa, emaila) VALUES ('$izenAbizenak', '$erabiltzailea', '$pasahitza', '$telefonoa', '$emaila')";
     $result = $conn->query($kontsulta);
    if ($result === TRUE) {
        echo "<br>";
        echo "Ondo erregistratu zara.";
    } else {
        echo "Error: " . $conn->error; 
    }

    ?>
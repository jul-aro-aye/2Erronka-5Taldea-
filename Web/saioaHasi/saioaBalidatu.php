<?php

require_once("../db.php");

if (isset($_GET["erabiltzailea"]) && !empty($_GET["erabiltzailea"])) { // erabiltzailea parametroa dagoela eta hutsa ez dela konprobatzen du
    $erabiltzailea = $_GET["erabiltzailea"]; // balioa aldagaiean gordetzen du
}

if (isset($_GET["pasahitza"]) && !empty($_GET["pasahitza"])) { // pasahitza parametroa dagoela eta hutsa ez dela konprobatzen du
    $pasahitza = $_GET["pasahitza"]; // balioa aldagaiean gordetzen du
}

if ($_GET["akzioa"] == "konprobatuSaioa") {

    $conn = konexioaSortu();

    $sql = "SELECT erabiltzailea, pasahitza FROM bezeroa WHERE erabiltzailea=\"$erabiltzailea\" AND pasahitza=\"$pasahitza\"";
    $result = $conn->query($sql);

    if ($result === false) { // Kontsultak errore bat duen konprobatzen du
        echo "Arazoa kontsulta egitean: " . $conn->error; // Errorearen mezua erakusten da.ç
        die(); // Prozesua amaitzen du
    }

    $saioa = [];

    if ($result->num_rows > 0) {

        $counter = 0;

        while ($row = $result->fetch_assoc()) {
            $saioa[$counter] = ["erabiltzailea" => $row["erabiltzailea"], "pasahitza" => $row["pasahitza"]];
            $counter++;
        }

        $saioa["kopurua"] = $counter;

        echo json_encode($saioa);
        die;

    } else {
        echo json_encode($saioa);
        die;
    }

}
?>
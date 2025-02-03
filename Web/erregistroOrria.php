<?php
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Erregistroa</title>
</head>

<body>
    <?php
    require_once("header.php");
    echo sortuMenua();
    ?>

    <form action="erregistroaGehitu.php" method="post">
        <label for="izenAbizenak">Izen-Abizenak:</label>
        <input type="text" id="izenAbizenak" name="izenAbizenak" required placeholder="xxxx xxxx xxxx"> <br><br>
        <label for="erabiltzailea">Erabiltzailea:</label>
        <input type="text" id="erabiltzailea" name="erabiltzailea" required  pattern="^[a-z]{3}_[a-z]{3}_[a-z]{3}$" title="Erabiltzailearen formatua ez da okerra, formatu egokia (xxx_xxx_xxx) da."> <br><br>
        <label for="pasahitza">Pasahitza:</label>
        <input type="password" id="pasahitza" name="pasahitza" required  pattern="^[a-zA-Z0-9!@#$%^&*()_+={}[\]:;<>,.?/-]{1,8}$" 
        title="8 karakter maximo eduki behar ditu, letrak, simbolo eta zenbakiak erabiliz"> <br><br>
        <label for="telefono">Telefonoa:</label>
        <input type="text" id="telefono" name="telefono" required placeholder="xxxxxxxxx"> <br><br>
        <label for="emaila">Emaila:</label> 
        <input type="email" id="emaila" name="emaila" placeholder="xxxxxx@gmail.com"> <br><br>
        <label for="jaio_urtea">Jaio Urtea:</label> 
        <input type="text" id="jaio_urtea" name="jaio_urtea" pattern="^[0-9]{"> <br><br>

        <br><br>
        
        <div id="erregistroa">
        <button id="erregistratuBotoia">Erregistratu</button>
        </div>
        
    </form>

</body>

</html>
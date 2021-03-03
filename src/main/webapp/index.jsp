<html>

<head>
    <meta charset=utf-8" />
    <link rel="stylesheet" href ="mystyle.css"/>

</head>
<body>
<h2 class="baslikayarlama"> GEOMETRIK SEKILLER </h2>

<div class="divayarlama">
<form  action="/SekilGirisi" METHOD="POST">
    <%--    <button type="submit" value=""/> --%>

    <table  class="center">
        <tr> <td> Sekil Adi: </td><td>
<%--            <input type="text" id="adi" name="adi"/> </td>--%>
            <select type="text" id="adi" name="adi">
                <option value="kare">Kare</option>
                <option value="dikdortgen">Dikdortgen</option>
                <option value="daire">Daire</option>
            </select>



        </tr>
        <tr> <td> Eni: </td><td><input type="number" id="x" name="eni"/> </td> </tr>
        <tr> <td>  Boyu: </td><td><input type="number" id="y" name="boyu"/> </td> </tr>
        <tr> <td>  Yaricapi: </td><td><input type="number" id="r" name="yaricap"/> </td> </tr>
        <tr> <td>  <input type = "submit" class="kaydetmebuttonu" value = "KAYDET" /> </td> </tr>
        <tr>
    </table>

</form>
<form method="get" action="/SekilListesi">
    <button type="submit" class="listelebuttonu">Sekilleri Listele</button>
</form>
</div>

<%--<form action="/Ogrenci" METHOD="GET">--%>
<%--    <input type="text" id="adi" name="adi"/>--%>
<%--    <input type = "submit" value = "Submit" />--%>

<%--&lt;%&ndash;    <button type="submit" value=""/> &ndash;%&gt;--%>
<%--</form>--%>



</body>
</html>

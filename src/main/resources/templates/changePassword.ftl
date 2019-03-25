<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sweater</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<form method="post" action="/changepassword">
    <input type="hidden" name="id" value="${user.id}">
    <input type="text" name="newPassword" placeholder="newPassowrd">
    <button type="submit"> Submit </button>
</form>
</body>
</html>

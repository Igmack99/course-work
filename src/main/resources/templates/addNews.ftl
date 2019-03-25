<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sweater</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<form method="post" action="/news/add">
    <input type="number" min="0" name="id" placeholder="id">
    <input type="number" min="0" name="author_id" placeholder="author_id">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="content" placeholder="content">
    <input type="radio" name="is_approved" placeholder="is_approved">
    <input type="date" min="0" name="date" placeholder="date">
    <button type="submit"> Submit </button>
</form>

<form method="post" action="/news/delete">
    <input type="number" name="id"/>
    <input type="submit" name="submit" value="submit">
</form>


</body>
</html>
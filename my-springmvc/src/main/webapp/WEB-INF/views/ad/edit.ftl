<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <form>
        <input type="button" value="提交" onclick="saveEdit();"/>
    </form>
</div>
<script src="/js/jquery.js"></script>
<script>

    function saveEdit() {
       var formData = new FormData();
        formData.append('id',2);
        //formData["name"] = "abc";
       // formData["ids"] = [2, 3];
        $.ajax({
            url: "/ad/paramByList",
            type: "POST",
            data:  formData,
            cache:false,
            contentType: false,
            processData: false,
            success: function (dat) {
                console.log(dat);
                $("#imgview").attr("src", dat);
            },
            error: function (dat) {
                console.log(dat);
            }
        });
    }

</script>
</body>
</html>
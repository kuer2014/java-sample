<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>上传图片</h3>
<#---->
<h4>1，普通提交，会刷新页面</h4>
<form action="/upload/uploadImg1" method="post" enctype="multipart/form-data">
    <input type="file" name="imgFile"/>
    <input type="submit" value="提交"/>
<br/>
</form>
<hr>
<#--2，ajax上传，支持多文件-->
<h4>2，ajax上传，支持多文件</h4>
<form id="formfile">
    <input type="file" name="imgFile"/>
    <input type="file" name="imgFile2"/>
    <input type="button" onclick="ajaxUpload1();" value="提交">
    <br/>
    预览：
    <div><img src="/image/w3c.png" id="imgview2"></div>
</form>
<hr>
<#--3，ajax上传，不需要from标签的上传-->
<h4>3，ajax上传，不需要from标签的上传</h4>
<input type="file" onchange="ajaxUpload2(this);" >
    <br/>
    预览：
    <div><img src="/image/w3c.png" id="imgview3"></div>
<#--4 本地预览图片-->
<h4>4，本地预览图片</h4>
<p/>
<input type="file" name="imgFile3" id="imgFile3"/>
本地预览：<div class="preview_wrap"></div>
<script src="/js/jquery.js"></script>
<script>
function ajaxUpload1() {
    var formData =new FormData($("#formfile")[0]);
    $.ajax({
        url: "/upload/uploadImg2",
        type: "POST",
        data: formData,
        cache:false,
        contentType: false,
        processData: false,
        success: function (dat) {
console.log(dat);
            $("#imgview2").attr("src",dat);
        },
        error: function (dat) {
            console.log(dat);
        }
    });
}
function ajaxUpload2(input, isContinue, maxsizeM) {
    var maxsize = 10 * 1024 * 1024;//最大10M
    if (maxsizeM) maxsize = maxsizeM * 1024 * 1024;
    //是否支持
    if (typeof FileReader === 'undefined') {
        alert("抱歉，你的浏览器不支持 FileReader，请使用其它浏览器！");
        input.setAttribute('disabled', 'disabled');
    }
    if (input.files && input.files[0]) {
        var file = input.files[0],
            reader = new FileReader();
        if (file.type !== 'image/jpeg' && file.type !== 'image/png' && file.type !== 'image/jpg') {
            alert('不支持的图片文件!');
            return;
        }

        reader.onload = function (e) {
            var result = this.result;
            if (result.length >= maxsize) {
                mui.dialog.alertDialog("提示", '图片文件最大10M!');

            } else {
                //var blob=  convertBase64UrlToBlob(result,'image/jpeg');
                var blob = new Blob([result],{type:file.type});
                var formData = new FormData();
                formData.append('imgFile',blob,file.name);
                formData.append('imgFileName',"aa");
                $.ajax({
                    url: "/upload/uploadImg2",
                    type: "POST",
                    dataType: "text",
                    cache: false,
                    async:true,
                    processData:false,
                    contentType:false,
                    data:formData,
                    timeout:60000,
                    success: function (data) {
                        $("#imgview3").attr("src",data);
                        // if (isContinue) {
                        //     //$(input).parent(".files").next().val($(input).next().val()+"||"+obj.data);
                        //     //$("#shopImgs").val($("#shopImgs").val()+"||"+obj.data);
                        //     $(input).next().val(obj.data);
                        //     var shopImgsVal = "";
                        //     $(".shopImgUrl").each(function (n, ele) {
                        //         if (ele.value)
                        //             shopImgsVal += ele.value + "||";
                        //     });
                        //     $("#shopImgs").val(shopImgsVal);
                        //     $(input).parent(".files").css("background", "url('" + obj.data + "')").css("background-size", "100% 100%");
                        //     if ($(input).parent(".files").next().attr('type') == "hidden") {
                        //         var fileForm = "<div class=\"files lg-files fileinput-button\">"
                        //             + " <input type=\"file\" name=\"files[]\" multiple=\"\" style=\"width: 100%;height: 100%;\""
                        //             + "onchange=\"page.uploadImg(this,true);\">"
                        //             + " <input type=\"hidden\" class=\"shopImgUrl\"/>"
                        //             + " </div>";
                        //         $(input).parent(".files").after(fileForm);
                        //     }
                        // } else {
                        //     $(input).next().val(obj.data);
                        //     $(input).parent(".files").css("background", "url('" + obj.data + "')").css("background-size", "100% 100%");
                        // }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            }
        }

        //reader.readAsDataURL(file);//读取到base64的图片
        reader.readAsArrayBuffer(file);//读取到二进制流的图片
    }
}
////window.createObjectURL 图片本地预览方式之一
//preview img ： URL.createObjectURL 方式
document.getElementById('imgFile3').onchange = function(e){
    var ele =  document.getElementById('imgFile3').files[0];

    var createObjectURL = function(blob){
        return window[window.webkitURL ? 'webkitURL' : 'URL']['createObjectURL'](blob);
    };
    var newimgdata = createObjectURL(ele);

    var pvImg = new Image();
    pvImg.src = newimgdata;
    pvImg.setAttribute('id','previewImg');

    $('.preview_wrap').html('').append(pvImg);
}
</script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>验证码</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .content {
            background: #fff;
            padding: 0 40px;
            height: 476px;
        }

        .content .head {
            width: 100%;
            padding: 13px 0;
            border-bottom: 1px solid #E8E8E8;
        }

        .content .contentCnt {
            width: 100%;
            height: 260px;
            padding-top: 10px;
        }

        .content .contentCnt p:first-child {
            font-size: 14px;
            color: #333333;
            text-indent: 0;
            padding-bottom: 10px;
        }

        .content .contentCnt p {
            text-indent: 2em;
            font-size: 14px;
            color: #4E4E4E;
            margin-top: 10px;
        }

        .content .contentCnt p span {
            color: #1F9ED0;
            font-weight: bold;
        }

        .content .foot {
            padding: 13px 0;
            font-size: 14px;
            color: #BEBEBE;
            border-bottom: 1px solid #E8E8E8;
        }

        .content .name {
            margin-top: 10px;
            font-size: 14px;
            color: #333333;
        }

        .content .name span {
            float: right;
        }

    </style>
</head>

<body>
<div>
    <div class="content">
        <#--<p class="head"><img src='cid:pic'/></p>-->
        <div class="contentCnt">
            <p>尊敬的XX科技用户：</p>
            <p>您的邮箱验证码为<span>${code!''}</span>，请勿向任何人泄露。</p>
            <p>验证码将在30分钟之后失效，请尽快完成操作。</p>
        </div>
        <p class="foot">此邮件系统自动发送，请勿直接回复。</p>
        <p class="name"><span>XX信息科技有限公司</span></p>
    </div>
</div>
</body>

</html>
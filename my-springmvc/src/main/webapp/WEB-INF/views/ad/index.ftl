<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#--输出-->
<h2>${name}</h2>
isActive:${isActive?c}
<#--if判断-->
<#if isActive>
     isActive:${isActive?c}
<#elseif isActive?? >
<#else >
</#if>
<#--List-->
<#--<#list animails as animal>-->
    <#--<div>${animal.name}</div>-->
<#--</#list>-->
<#--include-->
  <#include "partpage.html">
<div>

</div>
</body>
</html>
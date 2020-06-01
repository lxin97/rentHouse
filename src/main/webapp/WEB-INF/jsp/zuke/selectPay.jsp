<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/text2/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/text2/css/main.css"/>
    <script type="text/javascript" src="/text2/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="/text2/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/text2/js/jquery-ui-datepicker.js"></script>
    <script type="text/javascript" src="/text2/js/jquery.validate.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/text2/css/jquery-ui.css"/>
   <style>
   

.error {
  
  font-size:13px;
  color: red;
  
}

   </style>
    <script type="text/javascript">

	</script>
	
</head>
<body>
<div class="result-title">
<h1>选择支付方式</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form action="/create.action" method="POST" id="myform" name="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                           <tr>
                                <td rowspan="2" width="300px">
                                    <i class="require-red" >*</i>支付方式：</td>
                                <td>
                                    <input type="radio" value="alipay" name="vendor" checked="checked"/>支付宝
                                </td>
                           </tr>
                           <tr>
                               <td>
                                   <input type="radio" value="wechatpay" name="vendor" />微信
                               </td>
                           </tr>
                           <tr>
                               <td>
                                   <input type="text" value="${toPaidId }"  name="toPaidId" style="visibility: hidden;" />
                               </td>
                           </tr>
                           <tr align="center">
                               <td >
                               </td>
                               <td>
                                   <input class="btn btn-primary btn6 mr10" value="立即支付" type="submit">
                                   <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                           </td>
                           </tr>
                           <tr>
                               <font id="error" color="red">${error }</font>
                           </tr>
                        </tbody></table>
                </form>
          </div>
          </div>
    
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/NewFile.css" />" rel="stylesheet">

<style>

body{
}


.box-wrapper {
  perspective: 800px;
  perspective-origin: 50% 100px;
}

.box {
  position: relative;
  width: 200px;
  transform-style: preserve-3d;
}
.box p {
  padding: 40px 0;
}
.box div {
  outline: 1px solid #999;
  position: absolute;
  width: 200px;
  height: 200px;
  opacity: 0.98;
  box-shadow: inset 0px 0px 100px #555;
}

.back {
  transform: translateZ(-100px) rotateY(180deg);
  background-color: #eee;
}
.right {
  transform: rotateY(-270deg) translateX(100px);
  transform-origin: top right;
  background-color: #ddd;
}
.left {
  transform: rotateY(270deg) translateX(-100px);
  transform-origin: center left;
  background-color: #ddd;
}
.top {
  transform: rotateX(-90deg) translateY(-100px);
  transform-origin: top center;
  background-color: #fafafa;
}
.bottom {
  transform: rotateX(90deg) translateY(100px);
  transform-origin: bottom center;
  background-color: #bbb;
}
.front {
  transform: translateZ(100px);
  background-color: #eee;
}


@keyframes spin {
  from { transform: rotateY(0); }
  to { transform: rotateY(360deg); }
}

.box, .shadow {
  animation: spin 15s infinite linear;
}

.left p { color: #27a05c; }
.right p { color: #27a05c; }
.front p { color: #27a05c; }
.back p { color: #27a05c; }

.shadow-wrapper {
  perspective: 800px;
  perspective-origin: 50% 100px;
/*  -webkit-perspective: 800px;
  -webkit-perspective-origin: 50% 100px;*/
}

.shadow {
  position: relative;
  width: 200px;
  transform-style: preserve-3d;
}

.shadow div{
  position: absolute;
  width: 200px;
  height: 200px;
  top: 2px;
  opacity: 0.98;
  box-shadow: 0px 0px 100px #000;
  transform: rotateX(90deg) translateY(100px);
  transform-origin: bottom center;
}


</style>


</head>

<body>

<h2 align="center" style="padding-bottom: 8px">Cube processing</h2>
<div align="center" class="container" style="padding-right:30%;padding-left:30%">
	<form:form method="POST"
		action="${pageContext.servletContext.contextPath}/processDimension">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<form:input style="width:inherit;margin-bottom:3px"
						type="number" path="dimension.length" class="form-control"
						id="dimLength"/>
					<form:select style="width:100%" path="dimension.unit" id="unit">
	    				<form:options items="${unitList}"  /> 
					</form:select>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<form:input  style="width:inherit;margin-bottom:3px"
						type="text" path="cube.length" class="form-control"
						id="cubeLength" readonly="true"/>
					<form:select style="width:100%" path="cube.unit" id="cubeUnit">
	    				<form:options items="${unitList}"  /> 
					</form:select>
				</div>
			</div>
		</div>
	</form:form>
	<div style="padding-top:70px"></div>
	<div class="row box-check">
		<div class="shadow-wrapper">
	   		<div class="shadow">
	     			<div>&nbsp;</div>
	   		</div>
	  	</div>
		  <div class="box-wrapper">
		    <div class="box">
		      <div class="front">
		      </div>
		      <div class="back">
		      </div>
		      <div class="top">&nbsp;</div>
		      <div class="bottom">&nbsp;</div>
		      <div class="left">
		      </div>
		      <div class="right">
		      </div>
		
		    </div><!-- end of .box -->
		  </div><!-- end of .box-wrapper -->
	</div>
</div>

</body>

<script type="text/javascript">
$('#unit').change(
		function(){$(this).closest('form').trigger('submit');
		$('.box-check').show();
});
$('#cubeUnit').change(
		function(){$(this).closest('form').trigger('submit');
		$('.box-check').show();
});
$("#dimLength").bind("change", function() {
	$(this).closest('form').trigger('submit');
	$('.box-check').show();
 });
</script>

</html>
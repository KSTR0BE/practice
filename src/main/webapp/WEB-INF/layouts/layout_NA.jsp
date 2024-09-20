<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cPath" value="${pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <tiles:insertAttribute name="preScript" />

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Updated: Apr 20 2024 with Bootstrap v5.3.3
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  
  	<c:if test="${not empty message }">
		<script>
			alert("${message}");
		</script>
		<c:remove var="message" scope="session"/>
	</c:if>
</head>

<body data-context-path="${cPath }">

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">
	<tiles:insertAttribute name="header" />
  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">
	<tiles:insertAttribute name="sidebar" />
  </aside><!-- End Sidebar-->

  <main id="main" class="main">
	<tiles:insertAttribute name="contentPage" />
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer" class="footer">
  	<tiles:insertAttribute name="footer" />
  </footer><!-- End Footer -->
	
	<tiles:insertAttribute name="postScript" />

</body>

</html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<head>      
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
	<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-es.js"></script>
	<script>
		$(function () {
			$.datepicker.setDefaults($.datepicker.regional["es"]);
			$(".datepicker").datepicker({
				firstDay: 1
			});
		});
	</script>
  
</head>
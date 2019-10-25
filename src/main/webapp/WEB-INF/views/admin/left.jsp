<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css"
	rel="stylesheet" type="text/css" />
<link rel="StyleSheet"
	href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dtree.js"></script>
</head>
<body>
	<table width="100" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="12"></td>
		</tr>
	</table>
	<table width="100%" border="0">
		<tr>
			<td>
				<div class="dtree">
					<a href="javascript: d.openAll();">展开所有</a> | <a
						href="javascript: d.closeAll();">关闭所有</a>
					<script type="text/javascript">
						d = new dTree('d');
						d.add('01', -1, '系统菜单树');
						d.add('0101', '01', '会员管理', '', '', 'mainFrame');
						d
								.add(
										'010101',
										'0101',
										'会员管理',
										'listUser/1',
										'', 'mainFrame');
						d.add('0106', '01', '组织管理', '', '', 'mainFrame');
						d
								.add(
										'010601',
										'0106',
										'组织管理',
										'listOrganization/1',
										'', 'mainFrame');
						
						d.add('0102', '01', '一级分类管理', '', '', 'mainFrame');
						d
								.add(
										'010201',
										'0102',
										'一级分类管理',
										'${pageContext.request.contextPath}/listCategory/1',
										'', 'mainFrame');
						d.add('0103', '01', '二级分类管理');
						d
								.add(
										'010301',
										'0103',
										'二级分类管理',
										'${pageContext.request.contextPath}/listCategorySecond/1',
										'', 'mainFrame');
						d.add('0104', '01', 'Post管理');
						d
								.add(
										'010401',
										'0104',
										'Post管理',
										'${pageContext.request.contextPath}/listPost/1',
										'', 'mainFrame');
						d.add('0107', '01', 'Activities management', '', '', 'mainFrame');
						d
								.add(
										'010701',
										'0107',
										'Activities management',
										'listActivity/1',
										'', 'mainFrame');
						d.add('0105', '01', 'Donation管理');
						d
								.add(
										'010501',
										'0105',
										'Donation管理',
										'${pageContext.request.contextPath}/listOrder/1',
										'', 'mainFrame');
						document.write(d);
					</script>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>

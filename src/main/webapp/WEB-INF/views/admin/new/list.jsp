<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/tagList.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach bai viet</title>
</head>
<body>
<body>
	<div class="main-content">
		<form action="" id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
				    <div class="widget-box table-filter">
                        <div class="table-btn-controls">
                            <div class="pull-right tableTools-container">
                                <div class="dt-buttons btn-overlap btn-group">
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                       title='Thêm bài viết' href=''>
                                            <span>
                                                <i class="fa fa-plus-circle bigger-110 purple"></i>
                                            </span>
                                    </a>
                                    <button id="btnDelete" type="button"
                                        class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
                                            <span>
                                                <i class="fa fa-trash-o bigger-110 pink"></i>
                                            </span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <h1></h1>
					<div class="row">
						<div class="col-xs-12"></div>

	                    <h1></h1>
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
									    <th> <input type="checkbox" id="checkAll"> </th>
										<th>Tên bài viết</th>
										<th>Mô tả ngắn</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.listResult}">
										<tr>
										    <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
											<td>${item.title}</td>
											<td>${item.shortDescription}</td>
											<td>
                                                <c:url var="editURL" value="/admin-new">
                                                    <c:param name="type" value="edit"/>
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                   title="Cập nhật bài viết" href=''><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                </a>
                                            </td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
                            <h1></h1>
							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" name="page" id="page">
							<input type="hidden" value="" name="maxPageItem" id="maxPageItem">
							<input type="hidden" value="" name="type" id="type">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
		var currenntPage = ${model.page};
		var totalPages = ${model.totalPage};
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currenntPage,
				onPageClick : function(event, page) {
					//console.info(page + ' (from options)');
					if (page != currenntPage) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});
		$('#btnDelete').click(function(){
		    var data={};
            var ids = $('tbody input[type=checkbox]:checked').map(function(){
                return $(this).val();
            }).get();
            data['ids'] = ids;
            deleteNew(data);
		});

		function deleteNew(data){
            $.ajax({
                url: '',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    window.location.href = "${NEWurl}?type=list&maxPageItem=2&page=1&message=delete_success";
                },
                error: function (error) {
                    window.location.href = "${NEWurl}?type=list&maxPageItem=2&page=1&message=delete_error";
                }
            });
            }
	</script>
</body>
</html>
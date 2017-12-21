window.setTimeout(function () {
    $(".alert").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
    });
}, 2000);
$(document).ready(function () {
// 							$("#datepicker").datepicker({
// 								dateFormat : "yyyy-MM-dd HH:mm"
// 							});
    var contextRoot = "/" + window.location.pathname.split('/')[1];
    $("#feedbackFrm").submit(function (e) {
        e.preventDefault();
    });
    $("#sendMsgBtn").click(function (e) {
        var dataTosend = $("#comment").val();
        var id = $("#feedbackPropertyId").val();
        $.ajax({
            url: contextRoot + '/feedback/addFeedback/' + id,
            type: 'post',
            dataType: 'json',
            data: dataTosend,
            contentType: 'application/json',
            success: function (responseObj) {
                // data.form contains the HTML for the replacement form
                $('#feedbackBoard').html(function () {
                    return '<div class="alert alert-success alert-dismissable">'
                        + '<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>'
                        + '<strong>Successful!</strong>'
                        + '</div>'
                });
                $feedbackHtml = '<div class="panel panel-default feedback">';
                $feedbackHtml += '<div class="panel-heading feedback_header">';
                $feedbackHtml += '(<b>';
                console.log(responseObj);
                if (responseObj.account.role.id == 1) {
                    $feedbackHtml += 'Buyer';
                } else if (responseObj.account.role.id == 2) {
                    $feedbackHtml += 'Seller';
                } else if (responseObj.account.role.id == 3) {
                    $feedbackHtml += 'Agent';
                } else {
                    $feedbackHtml += 'ADMIN';
                }
                $feedbackHtml += '</b>) - ' + responseObj.account.firstName + ' ' + responseObj.account.lastName;
                $feedbackHtml += '</div>';
                $feedbackHtml += '<div class="panel-body feedback_content">';
                $feedbackHtml += responseObj.comment;
                $feedbackHtml += '<div>';
                $feedbackHtml += 'Posted on :';
                $feedbackHtml += responseObj.registerDate;
                $feedbackHtml += '</div>';
                $feedbackHtml += '</div>';
                $feedbackHtml += '</div>';
                $('#feedbackMsg').append($feedbackHtml);
                $('#comment').val('');
            },
            progress: function () {
                console.log('progress');
            },
            error: function (jqXHR, exception) {
                var msg = '';
                if (jqXHR.status === 0) {
                    msg = 'Not connect.\n Verify Network.';
                } else if (jqXHR.status == 404) {
                    msg = 'Requested page not found. [404]';
                } else if (jqXHR.status == 500) {
                    msg = 'Internal Server Error [500].';
                } else if (exception === 'parsererror') {
                    msg = 'Requested JSON parse failed.';
                } else if (exception === 'timeout') {
                    msg = 'Time out error.';
                } else if (exception === 'abort') {
                    msg = 'Ajax request aborted.';
                } else {
                    msg = 'Uncaught Error.\n' + jqXHR.responseText;
                }
                $('#feedbackBoard').html(function () {
                    return '<div class="alert alert-danger alert-dismissable">'
                        + '<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>'
                        + '<strong>Successful!</strong>'
                        + msg
                        + '</div>'
                });
            }
        })
            .done(function (jdata) {
            })
            .fail(function (jdata) {
                $("#feedbackBoard").text("fail" + jdata);
            })
    });

    $(".approveRequestBtn").click(function (e) {
        var dataTosend = $(this).attr('valId');
        var id = $(this).attr('valId');
        $(this).parentsUntil($("tr.approw")).parent().remove();
        $.ajax({
            url: contextRoot + '/approve/' + id,
            type: 'POST',
            dataType: 'json',
            data: dataTosend,
            contentType: 'application/json',
            success: function (responseObj) {
                $(this).parentsUntil($("tr.approw")).parent().remove();
            },
            progress: function () {
                console.log('progress');
            },
            error: function (jqXHR, exception) {
                var msg = '';
                if (jqXHR.status === 0) {
                    msg = 'Not connect.\n Verify Network.';
                } else if (jqXHR.status == 404) {
                    msg = 'Requested page not found. [404]';
                } else if (jqXHR.status == 500) {
                    msg = 'Internal Server Error [500].';
                } else if (exception === 'parsererror') {
                    msg = 'Requested JSON parse failed.';
                } else if (exception === 'timeout') {
                    msg = 'Time out error.';
                } else if (exception === 'abort') {
                    msg = 'Ajax request aborted.';
                } else {
                    msg = 'Uncaught Error.\n' + jqXHR.responseText;
                }

            }
        })
            .done(function (jdata) {
            })
            .fail(function (jdata) {
                console.log(jdata);
            })
    });

    $("#searchBtnHome").click(function (e) {
        var contextRoot = "/" + window.location.pathname.split('/')[1];
        var dataTosend = JSON.stringify(serializeObject($('#propertyListModelId')));
        $.ajax({
            url: '/property/ajaxsearch',
            type: 'POST',
            dataType: 'json',
            data: dataTosend,
            contentType: 'application/json',
            success: function (responseObj) {
                // data.form contains the HTML for the replacement form
                console.log("responseObj", responseObj);
                $("#owl-example").html("");
                var tmphtml = '<div class="owl-wrapper-outer"><div class="owl-wrapper" style="width: 480px; left: 0px; display: block; transition: all 1000ms ease; transform: translate3d(0px, 0px, 0px);"><div class="owl-item" style="width: 240px;">';
                if (responseObj.length > 0) {
                    $.each(responseObj, function (i, property) {
                        tmphtml += '<div class="properties"><div class="image-holder"><div class="status new"><b>' + property.propertyType + '</b> - <i>' + property.purposeName + '</i></div></div><h4><a href="/RealEstateManagement/property/propertyList?id=' + property.id + '">' + property.name + '</a></h4><p class="price">Price:</p><div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">1</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">3</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">4</span></div><a class="btn btn-primary" href="property/propertyList?id=' + property.id + '">View Details</a></div>';
                    });
                    tmphtml += '</div></div></div>';
                    $("#owl-example").html(tmphtml);
                } else {
                    $("#owl-example").html('<div class="alert alert-danger">NOT FOUND!!!!</div>');
                }
            },
            progress: function () {
                console.log('progress');
            },
            error: function (jqXHR, exception) {
                console.log("jqXHR", jqXHR);
                var msg = '';
                if (jqXHR.status === 0) {
                    msg = 'Not connect.\n Verify Network.';
                } else if (jqXHR.status == 404) {
                    msg = 'Requested page not found. [404]';
                } else if (jqXHR.status == 500) {
                    msg = 'Internal Server Error [500].';
                } else if (exception === 'parsererror') {
                    msg = 'Requested JSON parse failed.';
                } else if (exception === 'timeout') {
                    msg = 'Time out error.';
                } else if (exception === 'abort') {
                    msg = 'Ajax request aborted.';
                } else {
                    msg = 'Uncaught Error.\n' + jqXHR.responseText;
                }
                $("#owl-example").append('<div class="properties"><div class="image-holder"><img src="/uploadimage/' + property.mainPicturePath + '" class="img-responsive"><div class="status sold"><b>' + property.getPropertyType + '</b> - <i>' + property.getPurposeName + ' </i></div></div><h4><a href="<c:url value="/property/propertyList?id=' + property.id + '"/>">' + property.name + '</a></h4><p class="price">Price:<fmt:formatNumber value="' + property.purposeType.deposit + ' " type="currency" /></p><div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">' + property.bedroom + '</span></div><a class="btn btn-primary" href="property/propertyList?id=' + property.id + ' ">View Details</a></div>');
            }
        })
            .done(function (jdata) {
            })
            .fail(function (jdata) {
                console.log("jdata", jdata);
            })
    });
    $("#searchBtnHomeList").click(function (e) {
        var contextRoot = "/" + window.location.pathname.split('/')[1];
        var dataTosend = JSON.stringify(serializeObject($('#propertyListModelList')));
        $.ajax({
            url: '/property/ajaxsearchlist',
            type: 'POST',
            dataType: 'json',
            data: dataTosend,
            contentType: 'application/json',
            success: function (responseObj) {
                // data.form contains the HTML for the replacement form
                console.log("responseObj", responseObj);
                $("#searchResult").html("");
                var tmphtml = '<div class="owl-wrapper-outer"><div class="owl-wrapper" style="width: 480px; left: 0px; display: block; transition: all 1000ms ease; transform: translate3d(0px, 0px, 0px);"><div class="owl-item" style="width: 240px;">';
                if (responseObj.length > 0) {
                    $.each(responseObj, function (i, property) {
                        tmphtml += '<div class="properties"><div class="image-holder"><div class="status new"><b>' + property.propertyType + '</b> - <i>' + property.purposeName + '</i></div></div><h4><a href="/RealEstateManagement/property/propertyList?id=' + property.id + '">' + property.name + '</a></h4><p class="price">Price:</p><div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">1</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">2</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">3</span> <span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">4</span></div><a class="btn btn-primary" href="property/propertyList?id=' + property.id + '">View Details</a></div>';
                        //   	tmphtml += '<div class="row"><div class="col-lg-4 col-sm-5"></div>	<div class="col-lg-8 col-sm-7"><h5><a href="<c:url value="/property?id='+property.id+'"/>">'+property.name+'</a></h5><p class="price">Price:<fmt:formatNumber value="'+property.purposeType.deposit+'" type="currency" />	</p>	</div>	</div>'

                    });
                    tmphtml += '</div></div></div>';
                    $("#searchResult").html(tmphtml);
                } else {
                    $("#searchResult").html('<div class="alert alert-danger">NOT FOUND!!!!</div>');
                }
            },
            progress: function () {
                console.log('progress');
            },
            error: function (jqXHR, exception) {
                console.log("jqXHR", jqXHR);
                var msg = '';
                if (jqXHR.status === 0) {
                    msg = 'Not connect.\n Verify Network.';
                } else if (jqXHR.status == 404) {
                    msg = 'Requested page not found. [404]';
                } else if (jqXHR.status == 500) {
                    msg = 'Internal Server Error [500].';
                } else if (exception === 'parsererror') {
                    msg = 'Requested JSON parse failed.';
                } else if (exception === 'timeout') {
                    msg = 'Time out error.';
                } else if (exception === 'abort') {
                    msg = 'Ajax request aborted.';
                } else {
                    msg = 'Uncaught Error.\n' + jqXHR.responseText;
                }
                $("#owl-example").append('<div class="properties"><div class="image-holder"><img src="/uploadimage/' + property.mainPicturePath + '" class="img-responsive"><div class="status sold"><b>' + property.getPropertyType + '</b> - <i>' + property.getPurposeName + ' </i></div></div><h4><a href="<c:url value="/property/propertyList?id=' + property.id + '"/>">' + property.name + '</a></h4><p class="price">Price:<fmt:formatNumber value="' + property.purposeType.deposit + ' " type="currency" /></p><div class="listing-detail"><span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">' + property.bedroom + '</span></div><a class="btn btn-primary" href="property/propertyList?id=' + property.id + ' ">View Details</a></div>');
            }
        })
            .done(function (jdata) {
            })
            .fail(function (jdata) {
                console.log("jdata", jdata);
            })
    });
});

function serializeObject(form) {
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function () {
        jsonObject[this.name] = this.value;
    });
    return jsonObject;

};

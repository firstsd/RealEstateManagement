<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="body">

        <div class="inside-banner">
            <div class="container">
                <span class="pull-right"><a href="<c:url value="/index"/>">Home</a> / Requested Appointments</span>
                <h2><spring:message code="appointment.header" text="Requested Appointments"/></h2>
            </div>
        </div>
        <!-- banner -->
        <div class="container">
            <div class="spacer">
                <div class="row register">
                    <div class="col-lg-12 col-sm-12 col-xs-12 ">

                        <div class="table-responsive">
                            <table class="table table-hover">
                                <tr class="active">
                                    <th><spring:message code="appointment.property" text="Property Name"/></th>
                                    <th><spring:message code="appointment.address" text="Property Address"/></th>
                                    <th><spring:message code="appointment.owner" text="From Who"/></th>
                                    <th><spring:message code="appointment.appointment" text="Appointment"/></th>
                                    <th><spring:message code="appointment.date" text="Date"/></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                <c:forEach var="appointment" items="${appointments}">
                                    <tr class="active">
                                        <td>${appointment.property.name}</td>
                                        <td>${appointment.property.address}</td>
                                        <td>${appointment.buyer.firstName}</td>
                                        <td>${appointment.appointmentComment}</td>
                                        <td>${appointment.appointmentDate}</td>
                                        <td>
                                            <a href="<c:url value="/property/propertyList?id=${appointment.property.id}"/>">View
                                                Property</a></td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${appointment.getAppointmentStatus() == 'PENDING'}">
                                                    <a href="approve?id=${appointment.id}&status=1">Approve</a>
                                                    <a href="approve?id=${appointment.id}&status=0">Cancel</a>
                                                </c:when>
                                                <c:otherwise>
                                                    ${appointment.appointmentStatus}
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>
</html>

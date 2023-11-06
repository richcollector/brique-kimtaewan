<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/employee.css">
    </head>
    <body id="box">
        <div>
            <table>
                <thead>
                    <tr>
                        <th>종업원 번호</th>
                        <th>이름</th>
                        <th>성</th>
                        <th>성별</th>
                        <th>고용일자</th>
                        <th>부서 이름</th>
                        <th>직급</th>
                        <th>최대 급여</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="list" items="${employeeList}" varStatus="status">
                        <tr>
                            <td>${list.emp_no}</td>
                            <td>${list.first_name}</td>
                            <td>${list.last_name}</td>
                            <td>${list.gender}</td>
                            <td>${list.hire_date}</td>
                            <td>${list.dept_name}</td>
                            <td>${list.title}</td>
                            <td>${list.hire_salary}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
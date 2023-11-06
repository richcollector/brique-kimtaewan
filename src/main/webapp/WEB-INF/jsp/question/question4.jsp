<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/chart.css">
</head>
<body id="box">
    <div id="container">
        <div id="tableBox">
            <table>
                <thead>
                    <tr>
                        <th></th>
                        <th style="text-align: right;">평균 기온</th>
                        <th style="text-align: right;">평균 습도</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" begin="1" end="12">
                        <c:choose>
                            <c:when test="${i % 2 == 1}">
                                <tr>
                                    <td style="width: 70px; text-align: left;">${i}월</td>
                                    <td style="text-align: right;">
                                        <input onkeyup="updateChart()" type="number" class="temperature" id="temperature${i}">
                                    </td>
                                    <td style="text-align: right;">
                                        <input onkeyup="updateChart()" type="number" class="climate" id="climate${i}">
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td style="width: 70px; text-align: left; background-color: #f5f5f5;">${i}월</td>
                                    <td style="text-align: right; background-color: #f5f5f5;">
                                        <input onkeyup="updateChart()" type="number" class="temperature" id="temperature${i}">
                                    </td>
                                    <td style="text-align: right; background-color: #f5f5f5;">
                                        <input onkeyup="updateChart()" type="number" class="climate" id="climate${i}">
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </tbody>
            </table>
            <button onclick="random()">Random</button>
        </div>
        <div id="chartBox">
            <canvas id="myChart"></canvas>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="${pageContext.request.contextPath}/chart/chart.js"></script>
</body>
</html>
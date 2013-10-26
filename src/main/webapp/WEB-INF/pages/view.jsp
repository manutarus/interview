<!DOCTYPE HTML>
<html xmlns:ng="http://angularjs.org">
<head>
    <title>Debz</title>
    <link rel="stylesheet" href="resources/css/styles.css" />


</head>

<body ng:controller="RouteCtrl">

<div id="header">
    Debz System
    <button ng:click="addWine()">New Wine</button>
</div>

<div id="sidebar">
    <ng:include src="'resources/partials/side-list.html'"></ng:include>
</div>

<div id="content">
    <ng:view></ng:view>
</div>

<script src="resources/lib/angular-0.9.19.min.js" ng:autobind></script>
<script src="resources/js/services.js"></script>
<script src="resources/js/controllers.js"></script>



</body>

</html>
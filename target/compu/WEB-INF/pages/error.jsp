<!DOCTYPE HTML>
<html xmlns:ng="http://angularjs.org">
<head>
    <title>swf</title>


</head>

<body ng-app="">
<div align="center">
    <form class="form-horizontal" id="login" action='view' method="POST" autocomplete="off">
        <fieldset>
            <legend>Please login to proceed</legend>
            <p></p>
            <p></p>
            <div class="row">
                The swf Society
            </div>
            <div class="row">
                <img src="resources/imgs/swf.png" alt="log in" width="300" height="170">
            </div><br>
            <div class="row">

                <span class="label label-important">Error login</span> || <a href="/swf/">Home</a>
            </div><br>
            <div class="row">

                <input class="span15" placeholder="username" type="text" required id="username" name="username" rel="popover" >

            </div> <br>

            <div class="row">
                <input class="span15" placeholder="password" type="password" required id="password" name="password" rel="popover">

            </div> <br>

            <div class="row">
                <button class="btn btn-success" type="submit" >--Login--</button>
            </div>


        </fieldset>
    </form>
    </div>

<script src="resources/js/angular.min.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/controllers.js"></script>
<link rel="stylesheet" href="resources/styles/custom/custom.css"/>
<link rel="stylesheet" href="resources/styles/bootstrap/css/bootstrap.css"/>
<script src="resources/js/jquery/jquery.js" />
<script src="resources/js/angular/angular.js"/>
<script src="resources/js/angular/angular-resource.js"/>

<script src="resources/js/ui-bootstrap/ui-bootstrap-custom-0.4.0.js"/>
<script src="resources/js/ui-bootstrap/ui-bootstrap-custom-tpls-0.4.0.js"/>

</body>

</html>


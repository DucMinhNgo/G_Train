
(function () {
    var app = angular.module('app', []);
    app.controller('embedded', embedded);

    embedded.$inject = ['$scope'];

    function embedded($scope) {
        /* jshint validthis:true */
        $scope.showLabel = true;
        $scope.showTrain = false;
        $scope.showV = false;

        $scope.showLabelFunc = function () {
            $scope.showLabel = true;
            $scope.showTrain = false;
            $scope.showV = false;
        }
        $scope.showTrainFunc = function () {
            $scope.showLabel = false;
            $scope.showTrain = true;
            $scope.showV = false;
        }
        $scope.showVFunc = function () {
            $scope.showLabel = false;
            $scope.showTrain = false;
            $scope.showV = true;
        }
        $scope.embeddedLabel = './Label.jsp';
        $scope.embeddedTrain = './Train.jsp';
        $scope.embeddedVisualize = './Visualize.jsp';
        $scope.myFuncC = function (myE) {
            $scope.x = myE.clientX;
            $scope.y = myE.clientY;
        }
    }
    //function zoomController(zoomtype, updatesize) {
    //    if (zoomtype == 1 && updatesize > 550) {
    //        return updatesize;
    //    } else if (zoomtype === 1 && updatesize < 550) {
    //        return updatesize * 1.09;
    //    } else if (zoomtype === 0 && updatesize > 20) {
    //        return updatesize / 1.09;
    //    } else {
    //        return updatesize;
    //    }
    //}

    //app.directive('myDraggable', ['$document', '$timeout', function ($document, $timeout) {
    //    return function (scope, element) {
    //        var startX = 0,
    //          startY = 0,
    //          x = 0,
    //          y = 0;
    //        scope.updateX = 0;
    //        scope.updatesize = 100;
    //        /* mouse wheel */
    //        var doScroll = function (e) {
    //            e = window.event || e;
    //            var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail)));
    //            $timeout(function () {
    //                if (delta == 1) {
    //                    scope.updatesize = zoomController(1, scope.updatesize);
    //                } else {
    //                    scope.updatesize = zoomController(0, scope.updatesize);

    //                }
    //            }, 30);
    //            e.preventDefault();
    //        };

    //        if (window.addEventListener) {
    //            window.addEventListener("mousewheel", doScroll, false);
    //            window.addEventListener("DOMMouseScroll", doScroll, false);
    //        } else {
    //            window.attachEvent("onmousewheel", doScroll);
    //        }
    //        /* mouse wheel */
    //        scope.zoomInImage = function () {
    //            scope.updatesize = zoomController(1, scope.updatesize);
    //        };
    //        scope.zoomOutImage = function () {
    //            scope.updatesize = zoomController(0, scope.updatesize);
    //        };

    //        element.on('mousedown', function (event) {
    //             Prevent default dragging of selected content
    //            event.preventDefault();
    //            startX = event.pageX - x;
    //            startY = event.pageY - y;
    //            $document.on('mousemove', mousemove);
    //            $document.on('mouseup', mouseup);
    //        });

    //        function mousemove(event) {
    //            y = event.pageY - startY;
    //            x = event.pageX - startX;

    //            scope.updateX = x;
    //            scope.updateY = y;

    //            scope.$apply();

    //            element.css({
    //                top: y + 'px',
    //                left: x + 'px'
    //            });
    //        }

    //        function mouseup() {
    //            $document.off('mousemove', mousemove);
    //            $document.off('mouseup', mouseup);
    //        }
    //    };
    //}]);
    app.directive('ngMouseWheelUp', function () {
        return function (scope, element, attrs) {
            element.bind("DOMMouseScroll mousewheel onmousewheel", function (event) {

                //cross-browser wheel delta
                var event = window.event || event; // old IE support
                var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));

                if (delta > 0) {
                    scope.$apply(function () {
                        scope.$eval(attrs.ngMouseWheelUp);
                    });

                    //for IE
                    event.returnValue = false;
                    //for Chrome and Firefox
                    if (event.preventDefault) event.preventDefault();
                }
            });
        };
    });


    app.directive('ngMouseWheelDown', function () {
        return function (scope, element, attrs) {
            element.bind("DOMMouseScroll mousewheel onmousewheel", function (event) {

                //cross-browser wheel delta
                var event = window.event || event; // old IE support
                var delta = Math.max(-1, Math.min(1, (event.wheelDelta || -event.detail)));

                if (delta < 0) {
                    scope.$apply(function () {
                        scope.$eval(attrs.ngMouseWheelDown);
                    });

                    //for IE
                    event.returnValue = false;
                    //for Chrome and Firefox
                    if (event.preventDefault) event.preventDefault();
                }
            });
        };
    });
})();

'use strict';

let routeCreationForm = document.getElementById('route-creation-form');

let routeGradeInput = document.getElementById('route-grade');
let routeSetterInput = document.getElementById('route-setter');
let routeColorInput = document.getElementById('route-color');
let gymIdInput = document.getElementById('gym-id');

routeCreationForm.addEventListener('submit', function() {

    event.preventDefault();

    let newRoute = {};
    newRoute.routeGrade = routeGradeInput.value;
    newRoute.routeSetter = routeSetterInput.value;
    newRoute.routeColor = routeColorInput.value;
    newRoute.gymId = gymIdInput.value;
   

    output.innerHTML += '<li>'+newRoute.routeGrade+'</li>';
    output.innerHTML += '<li>'+newRoute.routeSetter+'</li>';
    output.innerHTML += '<li>'+newRoute.routeColor+'</li>';
    output.innerHTML += '<li>'+newRoute.gymId+'</li>';
  
});

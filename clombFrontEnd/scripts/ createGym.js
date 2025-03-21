'use strict';

let gymCreationForm = document.getElementById('gym-creation-form');

let gymNameInput = document.getElementById('gym-name');
let gymAddressInput = document.getElementById('gym-address');


gymCreationForm.addEventListener('submit', function() {

    event.preventDefault();

    let newGym = {};
    newGym.gymName = gymNameInput.value;
    newGym.gymAddress = gymAddressInput.value;
   

    output.innerHTML += '<li>'+newGym.gymName+'</li>';
    output.innerHTML += '<li>'+newGym.gymAddress+'</li>';
  
});

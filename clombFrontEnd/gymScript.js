
const gymCreationForm = document.getElementById('gym-creation-form');

let gymNameInput = document.getElementById('gym-name');
let gymAddressnput = document.getElementById('gym-address');


gymCreationForm.addEventListener('submit', async (event) => {

    event.preventDefault();
  
  	output.innerHTML = "";

    let newGym = {};
    newGym.gymName = gymNameInput.value;
    newGym.gymAddress = gymAddressInput.value;

    console.log(newGym);

    try {
      const response = await fetch('http://localhost:5000/api/gyms', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(newGym)
      });

      if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
      }

      const result = await response.json();
      console.log('Response:', result);

      document.getElementById('gym-message').textContent = "Gym successfully registered!";
      document.getElementById('gym-message').style.color = "green";

      // Optional: Clear form fields after successful submission
      event.target.reset();
  } catch (error) {
      console.error('Error:', error.message);
      document.getElementById('gym-message').textContent = "Error submitting form. Try again.";
      document.getElementById('gym-message').style.color = "red";
  }

    // output.innerHTML += '<li>'+newUser.firstName+'</li>';
    // output.innerHTML += '<li>'+newUser.lastName+'</li>';
    // output.innerHTML += '<li>'+newUser.email+'</li>';
    // output.innerHTML += '<li>'+newUser.shoes+'</li>';
    // output.innerHTML += '<li>'+newUser.chalk+'</li>';
    // output.innerHTML += '<li>'+newUser.gender+'</li>';
    // output.innerHTML += '<li>'+newUser.username+'</li>';
    // output.innerHTML += '<li>'+newUser.password+'</li>';

});

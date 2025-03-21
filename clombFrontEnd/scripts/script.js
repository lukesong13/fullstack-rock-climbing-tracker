const userCreationForm = document.getElementById('user-creation-form');

let firstNameInput = document.getElementById('first-name');
let lastNameInput = document.getElementById('last-name');
let emailInput = document.getElementById('email');
let shoesInput = document.getElementById('shoes');
let chalkInput = document.getElementById('chalk');
let genderInput = document.getElementById('gender');
let usernameInput = document.getElementById('username');
let passwordInput = document.getElementById('password');


document.getElementById('fetch-users').addEventListener('click', async () => {
    try {
        const response = await fetch('http://localhost:5000/api/users');

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const users = await response.json();
        console.log('Users:', users);

        // Get the user list container
        const getObjectsList = document.getElementById('get-objects-list');
        getObjectsList.innerHTML = ''; // Clear previous entries

        // // Display users in a list
        // users.forEach(user => {
        //     const li = document.createElement('li');
        //   	const ul = document.createElement('ul');
        //   	li.textContent = `${user.id}`;
        //     // li.textContent = `${user.firstName} ${user.lastName} - ${user.email}`;
        //   	ul.textContent = '<li>' + ` ${user.firstName}` + '</li> <li>' + `${user.lastName}` + '</li> <li>' + `${user.email}` + '</li>';
          
        //   	li.appendChild(ul);
        //     getObjectsList.appendChild(li);
          	
        // });

        users.forEach(user => {
            const li = document.createElement('li');
            const ul = document.createElement('ul');

            li.textContent = `User ID: ${user.id}`;


            const firstNameLi = document.createElement('li');
            firstNameLi.textContent = `First Name: ${user.firstName}`;

            const lastNameLi = document.createElement('li');
            lastNameLi.textContent = `Last Name: ${user.lastName}`;

            const emailLi = document.createElement('li');
            emailLi.textContent = `Email: ${user.email}`;

            // add consts for: gender, username, password, chalk, shoes, createDate, and updateDate

            const genderLi = document.createElement('li');
            genderLi.textContent = `Gender: ${user.gender}`;

            const usernameLi = document.createElement('li');
            usernameLi.textContent = `Username: ${user.username}`;

            const chalkLi = document.createElement('li');
            genderLi.textContent = `Chalk: ${user.chalk}`;

            const shoesLi = document.createElement('li');
            genderLi.textContent = `Shoes: ${user.shoes}`;

            const createDateLi = document.createElement('li');
            genderLi.textContent = `Creation Date: ${user.createDate}`;

            const updateDateLi = document.createElement('li');
            genderLi.textContent = `Update Date: ${user.updateDate}`;



            ul.appendChild(firstNameLi);
            ul.appendChild(lastNameLi);
            ul.appendChild(emailLi);
            ul.appendChild(genderLi);
            ul.appendChild(usernameLi);
            ul.appendChild(chalkLi);
            ul.appendChild(shoesLi);
            ul.appendChild(createDateLi);
            ul.appendChild(updateDateLi);


            li.appendChild(ul);

       
            getObjectsList.appendChild(li);

            
        });


    } catch (error) {
        console.error('Error:', error.message);
        document.getElementById('message').textContent = "Error fetching users.";
        document.getElementById('message').style.color = "red";
    }
});



/* 
POST REQS START HERE
*/
userCreationForm.addEventListener('submit', async (event) => {

    event.preventDefault();
  
  	output.innerHTML = "";

    let newUser = {};
    newUser.firstName = firstNameInput.value;
    newUser.lastName = lastNameInput.value;
    newUser.email = emailInput.value;
    newUser.shoes = shoesInput.value;
    newUser.chalk = chalkInput.value;
    newUser.gender = genderInput.value;
    newUser.username = usernameInput.value;
    newUser.password = passwordInput.value;

    console.log(newUser);

    try {
      const response = await fetch('http://localhost:5000/api/users', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(newUser)
      });

      if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
      }

      const result = await response.json();
      console.log('Response:', result);

      document.getElementById('message').textContent = "User successfully registered!";
      document.getElementById('message').style.color = "green";

      // Optional: Clear form fields after successful submission
      event.target.reset();
  } catch (error) {
      console.error('Error:', error.message);
      document.getElementById('message').textContent = "Error submitting form. Try again.";
      document.getElementById('message').style.color = "red";
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


const gymCreationForm = document.getElementById('gym-creation-form');

let gymNameInput = document.getElementById('gym-name');
let gymAddressInput = document.getElementById('gym-address');


gymCreationForm.addEventListener('submit', async (event) => {

    event.preventDefault();
  
  	// output.innerHTML = "";

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



  const routeCreationForm = document.getElementById('route-creation-form');

  let routeGradeInput = document.getElementById('route-grade');
  let routeColorInput= document.getElementById('route-color');
  let routeSetterInput = document.getElementById('route-setter');
  let gymIdInput= document.getElementById('gym-id');

    routeCreationForm.addEventListener('submit', async (event) => {

      event.preventDefault();
    
      // output.innerHTML = "";
  
      let newRoute = {};
      newRoute.grade = routeGradeInput.value;
      newRoute.setter = routeSetterInput.value;
      newRoute.color = routeColorInput.value;
      newRoute.gymId = gymIdInput.value;
  
      console.log(newRoute);
  
      try {
        const response = await fetch('http://localhost:5000/api/routes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newRoute)
        });
  
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
  
        const result = await response.json();
        console.log('Response:', result);
  
        document.getElementById('route-message').textContent = "Route successfully registered!";
        document.getElementById('route-message').style.color = "green";
  
        // Optional: Clear form fields after successful submission
        event.target.reset();
    } catch (error) {
        console.error('Error:', error.message);
        document.getElementById('route-message').textContent = "Error submitting form. Try again.";
        document.getElementById('route-message').style.color = "red";
    }
});


const climbDetailsCreationForm = document.getElementById('climbDetails-creation-form');

  let climbDetailsUserIdInput = document.getElementById('climbDetails-userId');
  let climbDetailsRouteIdInput = document.getElementById('climbDetails-routeId');
  let climbDetailsGymIdInput = document.getElementById('climbDetails-gymId');
  let climbDetailsNotesInput = document.getElementById('climbDetails-notes');
  


climbDetailsCreationForm.addEventListener('submit', async (event) => {

  event.preventDefault();

  // output.innerHTML = "";

  let newClimbDetails = {};
  newClimbDetails.userId = climbDetailsUserIdInput.value;
  newClimbDetails.routeId = climbDetailsRouteIdInput.value;
  newClimbDetails.gymId = climbDetailsGymIdInput.value;
  newClimbDetails.notes = climbDetailsNotesInput.value;

  console.log(newClimbDetails);

  try {
    const response = await fetch('http://localhost:5000/api/climbDetails', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newClimbDetails)
    });

    if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const result = await response.json();
    console.log('Response:', result);

    document.getElementById('climbDetails-message').textContent = "Climb Details successfully registered!";
    document.getElementById('climbDetails-message').style.color = "green";

    // Optional: Clear form fields after successful submission
    event.target.reset();
} catch (error) {
    console.error('Error:', error.message);
    document.getElementById('climbDetails-message').textContent = "Error submitting form. Try again.";
    document.getElementById('climbDetails-message').style.color = "red";
}
});



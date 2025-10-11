/**
 * forms.js
 * Handles sign-in and sign-up form submissions
 */

// Wait for DOM to be fully loaded
document.addEventListener('DOMContentLoaded', function() {
    
    // Sign In Form Handler
    const signinForm = document.getElementById('signinForm');
    if (signinForm) {
        signinForm.addEventListener('submit', handleSignIn);
    }
    
    // Sign Up Form Handler
    const signupForm = document.getElementById('signupForm');
    if (signupForm) {
        signupForm.addEventListener('submit', handleSignUp);
    }
});

/**
 * Handle Sign In form submission
 * @param {Event} e - The form submit event
 */
function handleSignIn(e) {
    e.preventDefault();
    
    // Get form values
    const email = document.getElementById('signinEmail').value;
    const password = document.getElementById('signinPassword').value;
    
    // Validate inputs
    if (!validateEmail(email)) {
        showAlert('Please enter a valid email address', 'warning');
        return;
    }
    
    if (password.length < 6) {
        showAlert('Password must be at least 6 characters long', 'warning');
        return;
    }
    
    // Simulate sign in (replace with actual API call)
    console.log('Sign In:', { email, password });
    showAlert(`Welcome back! Signing in with ${email}`, 'success');
    
    // Close modal
    closeModal();
    
    // Reset form
    e.target.reset();
}

/**
 * Handle Sign Up form submission
 * @param {Event} e - The form submit event
 */
function handleSignUp(e) {
    e.preventDefault();
    
    // Get form values
    const name = document.getElementById('signupName').value;
    const email = document.getElementById('signupEmail').value;
    const password = document.getElementById('signupPassword').value;
    const confirmPassword = document.getElementById('signupConfirmPassword').value;
    
    // Validate inputs
    if (name.trim().length < 2) {
        showAlert('Please enter a valid name', 'warning');
        return;
    }
    
    if (!validateEmail(email)) {
        showAlert('Please enter a valid email address', 'warning');
        return;
    }
    
    if (password.length < 6) {
        showAlert('Password must be at least 6 characters long', 'warning');
        return;
    }
    
    if (password !== confirmPassword) {
        showAlert('Passwords do not match!', 'danger');
        return;
    }
    
    // Simulate sign up (replace with actual API call)
    console.log('Sign Up:', { name, email, password });
    showAlert(`Welcome to Green Connect, ${name}! Account created successfully.`, 'success');
    
    // Close modal
    closeModal();
    
    // Reset form
    e.target.reset();
}

/**
 * Validate email format
 * @param {string} email - Email address to validate
 * @returns {boolean} - True if valid, false otherwise
 */
function validateEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

/**
 * Show alert message
 * @param {string} message - Alert message
 * @param {string} type - Alert type (success, warning, danger)
 */
function showAlert(message, type = 'info') {
    // Using browser's alert for simplicity
    // You can replace this with a custom alert/toast notification
    alert(message);
}

/**
 * Close the modal
 */
function closeModal() {
    const modal = document.getElementById('connectModal');
    if (modal) {
        const modalInstance = bootstrap.Modal.getInstance(modal);
        if (modalInstance) {
            modalInstance.hide();
        }
    }
}

/**
 * Optional: Store user data in memory (since localStorage is not available)
 * You can expand this to handle user sessions
 */
const userSession = {
    isLoggedIn: false,
    userData: null,
    
    login: function(userData) {
        this.isLoggedIn = true;
        this.userData = userData;
        console.log('User logged in:', userData);
    },
    
    logout: function() {
        this.isLoggedIn = false;
        this.userData = null;
        console.log('User logged out');
    },
    
    getUser: function() {
        return this.userData;
    }
};
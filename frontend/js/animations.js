/**
 * animations.js
 * Handles scroll-based animations for elements with .scroll-animate class
 */

// Intersection Observer options
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -50px 0px'
};

// Create Intersection Observer
const observer = new IntersectionObserver(function(entries) {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('animate');
        }
    });
}, observerOptions);

// Observe all elements with scroll-animate class
document.addEventListener('DOMContentLoaded', function() {
    const animateElements = document.querySelectorAll('.scroll-animate');
    
    animateElements.forEach(element => {
        observer.observe(element);
    });
});

/**
 * Optional: Re-observe elements if you want animations to repeat
 * Uncomment the code below if you want animations to trigger every time
 * an element enters the viewport
 */
/*
const repeatingObserver = new IntersectionObserver(function(entries) {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('animate');
        } else {
            entry.target.classList.remove('animate');
        }
    });
}, observerOptions);

document.addEventListener('DOMContentLoaded', function() {
    const animateElements = document.querySelectorAll('.scroll-animate');
    
    animateElements.forEach(element => {
        repeatingObserver.observe(element);
    });
});
*/
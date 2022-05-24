// ScrollFade 0.1

var fadeElements = document.getElementsByClassName('scrollFade');

function scrollFade() {

    for (let index = 0; index < fadeElements.length; index++) {
        let element = fadeElements[index];
        let rect = element.getBoundingClientRect();

        let elementFourth = rect.height/4;
        let fadeInPoint = window.innerHeight - elementFourth;
        let fadeOutPoint = -(rect.height/2);

        if (rect.top <= fadeInPoint) {
            element.classList.add('scrollFade--visible');
            element.classList.add('scrollFade--animate');
            element.classList.remove('scrollFade--hidden');
        } else {
            element.classList.remove('scrollFade--visible');
            element.classList.add('scrollFade--hidden');
        }

        if (rect.top <= fadeOutPoint) {
            element.classList.remove('scrollFade--visible');
            element.classList.add('scrollFade--hidden');
        }
    }
}

document.addEventListener('scroll', scrollFade);
window.addEventListener('resize', scrollFade);
document.addEventListener('DOMContentLoaded', function() {
    scrollFade();
});
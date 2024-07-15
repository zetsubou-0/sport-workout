$(document).ready(() => {
    $('.exercise-checkbox').on('click', (e) => {
        const $exerciseItemContainer = $(e.target).siblings('.exercise-item-container');
        $exerciseItemContainer.children('.exercise-data').toggleClass('hidden');
        $exerciseItemContainer.children('h4').toggleClass('success');
    })
})
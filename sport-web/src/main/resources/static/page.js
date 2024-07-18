$(document).ready(() => {
    $('.exercise-item').on('click', (e) => {
        var $exerciseItem = $(e.target)
        if (!$exerciseItem.hasClass('exercise-item')) {
            $exerciseItem = $exerciseItem.parents('.exercise-item')
        }
        $exerciseItem.children('.exercise-data').toggleClass('hidden');
        $exerciseItem.toggleClass('success')
    })
})
document.addEventListener
(
    'DOMContentLoaded', () => 
    {
        document.querySelectorAll('pre code').forEach
        (
            (codeEl) => 
            {
                const text = codeEl.textContent.replace(/^\n/, '');
                codeEl.textContent = text.replace(/^[ \t]{16}/gm, '');
            }
        )
    }
)
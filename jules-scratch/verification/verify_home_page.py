from playwright.sync_api import Page, expect

def test_home_page(page: Page):
    # Go to the home page
    page.goto("http://localhost:8080")

    # Expect the title to be "Omnichannel Ticket System"
    expect(page).to_have_title("Omnichannel Ticket System")

    # Take a screenshot
    page.screenshot(path="jules-scratch/verification/verification.png")

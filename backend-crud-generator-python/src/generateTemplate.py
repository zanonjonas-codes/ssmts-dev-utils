import os
import chevron
from pathlib import Path

# Function to prompt the user for input
def get_user_input(prompt):
    return input(prompt)

# Convert snake_case to CamelCase
def snake_to_camel(snake):
    components = snake.split('_')
    return ''.join(x.title() for x in components)

# Base directories
template_base_directory = 'chevron_template'
output_base_directory = './generated-template/'

# Prompt the user for the identifier
identifier = get_user_input("Please type the identifier that will be used to generate the Java classes: ")
capitalize_identifier = identifier.capitalize()

# Template directories
template_directories = ['main', 'test', 'fixture']

# Process templates in subdirectories
for template_directory in template_directories:
    template_dir_path = os.path.join(template_base_directory, template_directory)
    template_files = os.listdir(template_dir_path)
    
    output_subdirectory = os.path.join(output_base_directory, capitalize_identifier, template_directory, identifier)
    Path(output_subdirectory).mkdir(parents=True, exist_ok=True)

    # Render templates and save them to the output directory
    for template_file in template_files:
        with open(os.path.join(template_dir_path, template_file), 'r') as f:
            template_content = f.read()

        template_data = {
            'lower_identifier': identifier.lower(),
            'capitalize_identifier': capitalize_identifier
        }

        rendered_content = chevron.render(template_content, template_data)

        # Modify the template file name for the output file
        camel_case_identifier = snake_to_camel(identifier)
        new_file_name = f"{camel_case_identifier}{template_file}"
        output_path = os.path.join(output_subdirectory, new_file_name)

        # Save the rendered content to the output file
        with open(output_path, 'w') as f:
            f.write(rendered_content)

print("Templates generated successfully.")
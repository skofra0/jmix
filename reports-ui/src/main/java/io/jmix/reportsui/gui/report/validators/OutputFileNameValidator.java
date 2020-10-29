/*
 * Copyright (c) 2008-2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.reportsui.gui.report.validators;

import com.haulmont.cuba.core.global.Messages;
import io.jmix.reportsui.gui.report.wizard.ReportWizardCreator;
import io.jmix.ui.component.ValidationException;
import io.jmix.ui.component.validation.AbstractValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("report_OutputFileNameValidator")
public class OutputFileNameValidator extends AbstractValidator<String> {

    @Autowired
    protected Messages messages;

    @Override
    public void accept(String value) {
        if (StringUtils.isNotEmpty(value) && !value.matches("^[^/:*<>?\\\\]*$"))
            throw new ValidationException(String.format(
                    messages.getMessage(OutputFileNameValidator.class, "fillCorrectOutputFileNameMsg"),
                    messages.getMessage(ReportWizardCreator.class, "outputFileName")));
    }
}

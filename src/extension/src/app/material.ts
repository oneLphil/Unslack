import {MatButtonModule, MatCheckboxModule, MatTabsModule, MatListModule, MatToolbarModule, MatCardModule} from '@angular/material';
import { NgModule } from '@angular/core';

@NgModule({
    imports: [MatButtonModule, MatCheckboxModule, MatTabsModule, MatListModule, MatToolbarModule, MatCardModule],
    exports: [MatButtonModule, MatButtonModule, MatTabsModule, MatListModule, MatToolbarModule, MatCardModule],
})

export class MaterialModule {}

